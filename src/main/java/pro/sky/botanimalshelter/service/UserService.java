package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.listener.BotAnimalShelterUpdatesListener;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.model.Volunteer;
import pro.sky.botanimalshelter.repository.UserRepository;

/**
 * Service for working with the {@link User} entity
 */

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final UserRepository repository;

    private final TelegramBot telegramBot;

    public UserService(UserRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
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
