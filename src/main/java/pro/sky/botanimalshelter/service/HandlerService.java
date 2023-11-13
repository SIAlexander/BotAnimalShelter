package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.repository.HandlerRepository;

import java.util.List;

/**
 * Service for working with the {@link Handler} entity
 */
@Service
public class HandlerService {
    private final Logger logger = LoggerFactory.getLogger(HandlerService.class);
    private final HandlerRepository repository;
    private final TelegramBot telegramBot;

    public HandlerService(HandlerRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
    }

    /**
     * The method sends a list of handlers to the telegram bot chat
     *
     * @param chatId
     */
    public void sendHandlers(Long chatId) {
        List<Handler> handlers = repository.findByShelterName("/dog");
        try {
            for (Handler handler : handlers) {
                sendMessage(chatId, handler.getName());
                sendMessage(chatId, handler.getPhone());
            }
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
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
