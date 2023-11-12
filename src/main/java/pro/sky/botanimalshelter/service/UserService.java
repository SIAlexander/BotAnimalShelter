package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.listener.BotAnimalShelterUpdatesListener;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.UserRepository;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final UserRepository repository;

    private final TelegramBot telegramBot;

    public UserService(UserRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
    }

    public void saveUser(Long chatId, String name) {
        User user = new User(chatId, name);
        boolean exist = repository.existsByChatId(chatId);
        if (!exist) {
            repository.save(user);
        } else {
            logger.info("There is such a client");
        }
    }

    public void savePhone(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setPhone(text);
        repository.save(user);
    }

    public void saveEmail(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setEmail(text);
        repository.save(user);
    }

    public void saveLocation(Long chatId, String text) {
        User user = repository.findByChatId(chatId);
        user.setLocation(text);
        repository.save(user);
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        telegramBot.execute(sendMessage);
    }
}
