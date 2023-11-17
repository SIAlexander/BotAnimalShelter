package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.listener.BotAnimalShelterUpdatesListener;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.ReportUserCatShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserDogShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Service for working with the {@link User} entity
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final UserRepository repository;
    private final TelegramBot telegramBot;
    private final ReportUserCatShelterRepository reportCatRepository;
    private final ReportUserDogShelterRepository reportDogRepository;

    public UserService(UserRepository repository,
                       TelegramBot telegramBot,
                       ReportUserCatShelterRepository reportCatRepository,
                       ReportUserDogShelterRepository reportDogRepository) {
        this.repository = repository;
        this.telegramBot = telegramBot;
        this.reportCatRepository = reportCatRepository;
        this.reportDogRepository = reportDogRepository;
    }

    /**
     * The Method of saving to the user's database
     *
     * @param chatId
     * @param name
     */
    public void saveUser(Long chatId, String name) {
        User user = new User(chatId, name);
        boolean exist = repository.existsByChatId(chatId);
        if (!exist) {
            repository.save(user);
        } else {
            logger.info("There is such a client");
        }
    }

    /**
     * The method of saving the user's phone in the database
     *
     * @param chatId
     * @param text
     */
    public void savePhone(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setPhone(text);
        repository.save(user);
    }

    /**
     * The method of saving the user's email in the database
     *
     * @param chatId
     * @param text
     */

    public void saveEmail(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setEmail(text);
        repository.save(user);
    }

    /**
     * The method of saving the user's location in the database
     *
     * @param chatId
     * @param text
     */

    public void saveLocation(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setLocation(text);
        repository.save(user);
    }

    /**
     * method of sending the report from the user
     *
     * @param chatId
     * @param text
     * @param selectShelter
     * @param message
     */

    public void sendReportFromUser(Long chatId, String text, String selectShelter, String message) {
        ReportUserCatShelter reportUserCatShelter = new ReportUserCatShelter();
        ReportUserDogShelter reportUserDogShelter = new ReportUserDogShelter();
        User user = repository.findByChatId(chatId);

        LocalDateTime localDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        GetFile getFile = new GetFile(message);
        GetFileResponse response = telegramBot.execute(getFile);
        String urlImage = telegramBot.getFullFilePath(response.file());
        if (text.length() < 25) {
            sendMessage(chatId, "Маленькое описание, повторите отправку всего отчета");
        }
        if (selectShelter.equals("/cat") && text.length() > 25 && user.getShelter().getName().equals("/cat")) {
            reportUserCatShelter.setUrlPhoto(urlImage);
            reportUserCatShelter.setReport(text);
            reportUserCatShelter.setUser(user);
            reportUserCatShelter.setDateReport(Timestamp.valueOf(localDate));

            reportCatRepository.save(reportUserCatShelter);
        } else if (!user.getShelter().getName().equals("/cat")) {
            sendMessage(chatId, "Не правильно выбран приют для отчета");
        }
        if (selectShelter.equals("/dog") && text.length() > 25 && user.getShelter().getName().equals("/dog")) {
            reportUserDogShelter.setUrlPhoto(urlImage);
            reportUserDogShelter.setReport(text);
            reportUserCatShelter.setUser(user);
            reportUserDogShelter.setDateReport(Timestamp.valueOf(localDate));

            reportDogRepository.save(reportUserDogShelter);
        } else if (!user.getShelter().getName().equals("/dog")) {
            sendMessage(chatId, "Не правильно выбран приют для отчета");
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
}
