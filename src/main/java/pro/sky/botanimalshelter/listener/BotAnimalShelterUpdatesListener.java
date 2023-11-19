package pro.sky.botanimalshelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.service.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Listener for bot class updates
 */
@Service
public class BotAnimalShelterUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final TelegramBot telegramBot;
    private final KeyboardService keyboardService;
    private final UserService userService;
    private final PetShelterService petShelterService;
    private final VolunteerService volunteerService;
    private final HandlerService handlerService;
    private final RecommendationsSheltersService recommendationsSheltersService;
    private final ListDocumentService listDocumentService;
    private final PetService petService;

    private String selectShelter = null; //переменная для хранения выбранного приюта (кошачий/собачий)
    private String userName; //переменная для хранения имени пользователя
    private final Map<Long, Boolean> map = new HashMap<>(); //map для обработки входящих сообщений от пользователя(сохранение контактных данных)
    private final Map<Long, Boolean> mapReport = new HashMap<>(); //map для обработки входящих сообщений от пользователя(отправка отчета)
    private int count = 0; //счетчик для обработки входящих сообщений от пользователя
    private String urlPhoto; //переменная для хранения url фото(отправка отчета)

    public BotAnimalShelterUpdatesListener(TelegramBot telegramBot,
                                           KeyboardService keyboardService,
                                           UserService userService,
                                           PetShelterService petShelterService,
                                           VolunteerService volunteerService,
                                           HandlerService handlerService,
                                           RecommendationsSheltersService recommendationsSheltersService,
                                           ListDocumentService listDocumentService, PetService petService) {
        this.telegramBot = telegramBot;
        this.keyboardService = keyboardService;
        this.userService = userService;
        this.petShelterService = petShelterService;
        this.volunteerService = volunteerService;
        this.handlerService = handlerService;
        this.recommendationsSheltersService = recommendationsSheltersService;
        this.listDocumentService = listDocumentService;
        this.petService = petService;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    /**
     * Command processing method
     *
     * @param updates
     */
    @Override
    public int process(List<Update> updates) {

        updates.forEach(update -> {
            //Обрабатываем свои обновления здесь
            logger.info("Processing update: {}", update);
            Message message = update.message();
            String text;
            Long chatId;
            int messageId;

            if (message != null) {
                text = message.text();
                chatId = message.chat().id();
                messageId = message.messageId();
                userName = update.message().from().firstName();
            } else if (update.callbackQuery() != null) {
                text = update.callbackQuery().data();
                chatId = update.callbackQuery().message().chat().id();
                messageId = update.callbackQuery().message().messageId();
            } else {
                return;
            }
            logger.info(text);

            // clearMessage(chatId, messageId); пока под вопросом нужен он или нет

            try {
                if (text.equalsIgnoreCase("/start")) {
                    userService.saveUser(chatId, userName);
                    keyboardService.keyboardSelectionShelter(chatId);
                } else if (text.equalsIgnoreCase("/dog")) {
                    selectShelter = "/dog"; //поле name в таблице shelter должно быть заполнено как - /dog
                } else if (text.equalsIgnoreCase("/cat")) {
                    selectShelter = "/cat"; //поле name в таблице shelter должно быть заполнено как - /cat
                }
            } catch (NullPointerException e) {
                logger.info("null");
            }

            if (Boolean.TRUE.equals(map.get(chatId))) {
                count++;
                if (count == 1) {
                    userService.savePhone(chatId, text);
                }
                if (count == 2) {
                    userService.saveEmail(chatId, text);
                }
                if (count == 3) {
                    userService.saveLocation(chatId, text);
                }
                if (count == 4) {
                    map.remove(chatId);
                    count = 0;
                }
            }

            try {
                if (Boolean.TRUE.equals(mapReport.get(chatId))) {
                    count++;
                    if (count == 1) {
                        urlPhoto = update.message().photo()[0].fileId();
                    }
                    if (count == 2) {
                        userService.sendReportFromUser(chatId, text, selectShelter, urlPhoto);
                    }
                    if (count == 3) {
                        mapReport.remove(chatId);
                        count = 0;
                    }
                }
            }catch (NullPointerException e){
                logger.info("null sendReport");
                sendMessage(chatId, "Не правильный порядок отправки фото или текста, повторите отправку отчета");
                count = 0;
            }

            try {
                petShelterService.findShelter(selectShelter);
                botAnswerUtils(text, chatId, selectShelter, userName);
            }catch (NullPointerException e){
                logger.info("information from DB is empty");
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    /**
     * Method for processing commands from the keyboard
     *
     * @param text
     * @param chatId
     * @param selectShelter
     * @param userName
     */

    private void botAnswerUtils(String text, long chatId, String selectShelter, String userName) {
        switch (text) {
            case "/cat", "/dog" ->
                    keyboardService.menuSelectionShelter(chatId, selectShelter);
            case "/about shelter" ->
                    keyboardService.menuSelectionInformationShelter(chatId, selectShelter, userName);
            case "/about" ->
                    petShelterService.sendStoryShelter(chatId, selectShelter);
            case "/take animal" ->
                    keyboardService.menuSelectionShelterCatAndDog(chatId, selectShelter, userName);
            case "/contacts shelter" ->
                    petShelterService.sendDrivingDirections(chatId, selectShelter);
            case "/security contacts" ->
                    petShelterService.sendSecurityContact(chatId, selectShelter);
            case "/accept contact" -> {
                sendMessage(chatId, "Введите сообщениями контактные данные:\n 1. телефон\n 2. почта\n 3. адрес");
                map.put(chatId, true);
            }
            case "/send report" ->{
                sendMessage(chatId, "Пришлите отчет: \n 1. Фото\n 2.Описание");
                mapReport.put(chatId, true);
            }

            case "/call volunteer" ->
                    volunteerService.sendVolunteer(chatId, selectShelter);
            case "/documents" ->
                    listDocumentService.sendListDocuments(chatId, selectShelter);
            case "/recommendations transportation" ->
                    recommendationsSheltersService.sendRecommendationsTransportation(chatId, selectShelter);
            case "/dating rules" ->
                    recommendationsSheltersService.sendDatingRules(chatId, selectShelter);
            case "/recommendations home improvement" ->
                    recommendationsSheltersService.sendRecommendationsHomeImprovement(chatId, selectShelter);
            case "/communication dog" ->
                    recommendationsSheltersService.sendCommunicationDog(chatId, selectShelter);
            case "/recommendations home adult animal" ->
                    recommendationsSheltersService.sendRecommendationsHomeAdultAnimal(chatId, selectShelter);
            case "/recommendations home disabilities" ->
                    recommendationsSheltersService.sendRecommendationsHomeDisabilities(chatId, selectShelter);
            case "/refuse not you up" ->
                    recommendationsSheltersService.sendRefuseNotYouUp(chatId, selectShelter);
            case "/proven dog" ->
                    handlerService.sendHandlers(chatId);
            case "/show a list of animals" -> petService.sendAllPet(chatId, selectShelter);
        }
    }

    /**
     * The method of sending a message to the telegram  bot chat
     *
     * @param chatId
     * @param text
     */

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        telegramBot.execute(sendMessage);
    }

    /**
     * Chat clearing method
     *
     * @param chatId
     * @param messageId
     */

    private void clearMessage(Long chatId, int messageId) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
        telegramBot.execute(deleteMessage);
        logger.info("clear");
    }
}
