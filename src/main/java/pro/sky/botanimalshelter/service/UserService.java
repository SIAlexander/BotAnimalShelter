package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.listener.BotAnimalShelterUpdatesListener;
import pro.sky.botanimalshelter.model.*;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserCatShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserDogShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Service for working with the {@link User} entity
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final UserRepository userRepository;

    private final PetShelterRepository petShelterRepository;
    private final TelegramBot telegramBot;
    private final ReportUserCatShelterRepository reportCatRepository;
    private final ReportUserDogShelterRepository reportDogRepository;

    public UserService(UserRepository userRepository,
                       PetShelterRepository petShelterRepository, TelegramBot telegramBot,
                       ReportUserCatShelterRepository reportCatRepository,
                       ReportUserDogShelterRepository reportDogRepository) {
        this.userRepository = userRepository;
        this.petShelterRepository = petShelterRepository;
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
        boolean exist = userRepository.existsByChatId(chatId);
        if (!exist) {
            userRepository.save(user);
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
        User user = userRepository.findByChatId(chatId);
        user.setPhone(text);
        userRepository.save(user);
    }

    /**
     * The method of saving the user's email in the database
     *
     * @param chatId
     * @param text
     */

    public void saveEmail(Long chatId, String text) {
        User user = userRepository.findByChatId(chatId);
        user.setEmail(text);
        userRepository.save(user);
    }

    /**
     * The method of saving the user's location in the database
     *
     * @param chatId
     * @param text
     */

    public void saveLocation(Long chatId, String text) {
        User user = userRepository.findByChatId(chatId);
        user.setLocation(text);
        userRepository.save(user);
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
        User user = userRepository.findByChatId(chatId);
        LocalDateTime localDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        GetFile getFile = new GetFile(message);
        GetFileResponse response = telegramBot.execute(getFile);
        String urlImage = telegramBot.getFullFilePath(response.file());

        if (text.length() < 25) {
            sendMessage(chatId, "Маленькое описание, повторите отправку всего отчета");
        }

        if (selectShelter.equals("/cat") && text.length() > 25) {
            reportUserCatShelter.setUrlPhoto(urlImage);
            reportUserCatShelter.setReport(text);
            reportUserCatShelter.setDateReport(Timestamp.valueOf(localDate));
            reportUserCatShelter.setUser(user);
            reportCatRepository.save(reportUserCatShelter);
        }

        if (selectShelter.equals("/dog") && text.length() > 25) {
            reportUserDogShelter.setUrlPhoto(urlImage);
            reportUserDogShelter.setReport(text);
            reportUserDogShelter.setDateReport(Timestamp.valueOf(localDate));
            reportUserDogShelter.setUser(user);
            reportDogRepository.save(reportUserDogShelter);
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
     * @param id идентификатор пользователя
     * @return сущность пользователя или null, если пользователь с указанным идентификатором
     * отсутствует в базе данных
     */
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    /**
     * Сохраняем сущность пользователя
     *
     * @param user nullable
     * @return saved entity or null if null entity provided. Null entity is not saved.
     */
    public User saveUser(User user) {
        if (user == null) {
            return user;
        }
        return userRepository.save(user);
    }

}
