package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Telegram bot keyboard service
 */
@Service
public class KeyboardService {

    private final Logger logger = LoggerFactory.getLogger(KeyboardService.class);
    private final TelegramBot telegramBot;
    private static final InlineKeyboardButton DOG_SHELTER =
            new InlineKeyboardButton("Приют для собак");
    private static final InlineKeyboardButton CAT_SHELTER =
            new InlineKeyboardButton("Приют для кошек");
    private static final InlineKeyboardButton ABOUT_THE_SHELTER =
            new InlineKeyboardButton("Узнать информацию о приюте");
    private static final InlineKeyboardButton HOW_TO_TAKE_AN_ANIMAL =
            new InlineKeyboardButton("Как взять животное из приюта");
    private static final InlineKeyboardButton SEND_A_REPORT =
            new InlineKeyboardButton("Прислать отчет о питомце");
    private static final InlineKeyboardButton CALL_A_VOLUNTEER =
            new InlineKeyboardButton("Позвать волонтера");
    private static final InlineKeyboardButton ABOUT =
            new InlineKeyboardButton("Рассказать о приюте");
    private static final InlineKeyboardButton SCHEDULE_WORK_TRAVEL_CONTACTS =
            new InlineKeyboardButton("Схема проезда, режим работы, адрес");
    private static final InlineKeyboardButton SECURITY_CONTACTS =
            new InlineKeyboardButton("Контакты охраны для оформления пропуска");
    private static final InlineKeyboardButton ACCEPT_CONTACT_DETAILS =
            new InlineKeyboardButton("Принять контактные данные для связи");
    private static final InlineKeyboardButton DATING_RULES =
            new InlineKeyboardButton("Правила знакомства с животным");
    private static final InlineKeyboardButton LIST_OF_DOCUMENTS =
            new InlineKeyboardButton("Список документов чтобы взять животное");
    private static final InlineKeyboardButton LIST_OF_RECOMMENDATIONS_FOR_TRANSPORTATION =
            new InlineKeyboardButton("Рекомендаций по транспортировке животного");
    private static final InlineKeyboardButton LIST_OF_RECOMMENDATIONS_FOR_HOME_IMPROVEMENT =
            new InlineKeyboardButton("Рекомендации по обустройству дома");
    private static final InlineKeyboardButton LIST_OF_RECOMMENDATIONS_FOR_HOME_ADULT_ANIMAL =
            new InlineKeyboardButton("Рекомендации по обустройству дома взрослого животного");
    private static final InlineKeyboardButton LIST_OF_RECOMMENDATIONS_FOR_HOME_ANIMAL_WITH_DISABILITIES =
            new InlineKeyboardButton("Рекомендации по обустройству дома животного с ограниченными возможностями");
    private static final InlineKeyboardButton DOG_HANDLER_PRIMARY_COMMUNICATION_WITH_DOG =
            new InlineKeyboardButton("Кинолог по первичному общению с собакой");
    private static final InlineKeyboardButton PROVEN_DOG_HANDLERS =
            new InlineKeyboardButton("Рекомендации по проверенным кинологам для дальнейшего обращения к ним");
    private static final InlineKeyboardButton LIST_REASONS_THEY_REFUSE_NOT_YOU_UP =
            new InlineKeyboardButton("Список причин, почему могут отказать и не дать забрать");
    private static final InlineKeyboardButton SHOW_A_LIST_OF_ANIMALS =
            new InlineKeyboardButton("Список животных в приюте");

    public KeyboardService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    /**
     * The main menu of the bot
     *
     * @param chatId
     */

    public void keyboardSelectionShelter(Long chatId) {

        DOG_SHELTER.callbackData("/dog");
        CAT_SHELTER.callbackData("/cat");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(DOG_SHELTER, CAT_SHELTER);

        SendMessage sendMessage = new SendMessage(chatId, "Выберете приют").replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /**
     * The main menu of the shelter
     *
     * @param chatId
     * @param shelter
     */

    public void menuSelectionShelter(Long chatId, String shelter) {

        ABOUT_THE_SHELTER.callbackData("/about shelter");
        HOW_TO_TAKE_AN_ANIMAL.callbackData("/take animal");
        SEND_A_REPORT.callbackData("/send report");
        CALL_A_VOLUNTEER.callbackData("/call volunteer");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(HOW_TO_TAKE_AN_ANIMAL, SEND_A_REPORT);
        inlineKeyboardMarkup.addRow(CALL_A_VOLUNTEER, ABOUT_THE_SHELTER);

        SendMessage sendMessage = new SendMessage(chatId, "Выберете пункт меню").replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /**
     * Shelter menu
     *
     * @param chatId
     * @param shelter
     * @param userName
     */

    public void menuSelectionInformationShelter(Long chatId, String shelter, String userName) {

        ABOUT.callbackData("/about");
        SCHEDULE_WORK_TRAVEL_CONTACTS.callbackData("/contacts shelter");
        SECURITY_CONTACTS.callbackData("/security contacts");
        ACCEPT_CONTACT_DETAILS.callbackData("/accept contact");
        CALL_A_VOLUNTEER.callbackData("/call volunteer");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(ABOUT, SCHEDULE_WORK_TRAVEL_CONTACTS);
        inlineKeyboardMarkup.addRow(SECURITY_CONTACTS, ACCEPT_CONTACT_DETAILS);
        inlineKeyboardMarkup.addRow(CALL_A_VOLUNTEER);

        SendMessage sendMessage = new SendMessage(chatId, "Здравствуйте, " + userName).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /**
     * Menu for the button "How to take an animal from a shelter"
     *
     * @param chatId
     * @param shelter
     * @param userName
     */

    public void menuSelectionShelterCatAndDog(Long chatId, String shelter, String userName) {

        DATING_RULES.callbackData("/dating rules");
        LIST_OF_DOCUMENTS.callbackData("/documents");
        LIST_OF_RECOMMENDATIONS_FOR_TRANSPORTATION.callbackData("/recommendations transportation");
        LIST_OF_RECOMMENDATIONS_FOR_HOME_IMPROVEMENT.callbackData("/recommendations home improvement");
        LIST_OF_RECOMMENDATIONS_FOR_HOME_ADULT_ANIMAL.callbackData("/recommendations home adult animal");
        LIST_OF_RECOMMENDATIONS_FOR_HOME_ANIMAL_WITH_DISABILITIES.callbackData("/recommendations home disabilities");
        LIST_REASONS_THEY_REFUSE_NOT_YOU_UP.callbackData("/refuse not you up");
        ACCEPT_CONTACT_DETAILS.callbackData("/accept contact");
        CALL_A_VOLUNTEER.callbackData("/call volunteer");
        DOG_HANDLER_PRIMARY_COMMUNICATION_WITH_DOG.callbackData("/communication dog");
        PROVEN_DOG_HANDLERS.callbackData("/proven dog");
        SHOW_A_LIST_OF_ANIMALS.callbackData("/show a list of animals");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        if (shelter.equals("/cat")) {
            for (int i = 0; i < menuSelectionShelterCommon().length; i++) {
                inlineKeyboardMarkup.addRow(menuSelectionShelterCommon()[i]);
            }
            inlineKeyboardMarkup.addRow(CALL_A_VOLUNTEER);


        } else if (shelter.equals("/dog")) {
            for (int i = 0; i < menuSelectionShelterCommon().length; i++) {
                inlineKeyboardMarkup.addRow(menuSelectionShelterCommon()[i]);
            }
            inlineKeyboardMarkup.addRow(DOG_HANDLER_PRIMARY_COMMUNICATION_WITH_DOG);
            inlineKeyboardMarkup.addRow(PROVEN_DOG_HANDLERS);
            inlineKeyboardMarkup.addRow(CALL_A_VOLUNTEER);
        }

        SendMessage sendMessage = new SendMessage(chatId, "Здравствуйте, " + userName).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /**
     * The method of common buttons for shelters
     *
     * @return {@link InlineKeyboardButton}
     */

    private InlineKeyboardButton[] menuSelectionShelterCommon() {
        return new InlineKeyboardButton[]{
                DATING_RULES,
                LIST_OF_DOCUMENTS,
                LIST_OF_RECOMMENDATIONS_FOR_TRANSPORTATION,
                LIST_OF_RECOMMENDATIONS_FOR_HOME_IMPROVEMENT,
                LIST_OF_RECOMMENDATIONS_FOR_HOME_ADULT_ANIMAL,
                LIST_OF_RECOMMENDATIONS_FOR_HOME_ANIMAL_WITH_DISABILITIES,
                LIST_REASONS_THEY_REFUSE_NOT_YOU_UP,
                ACCEPT_CONTACT_DETAILS,
                SHOW_A_LIST_OF_ANIMALS};
    }
}
