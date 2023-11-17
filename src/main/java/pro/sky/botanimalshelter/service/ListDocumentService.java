package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.repository.ListDocumentRepository;

import java.util.List;

/**
 * Service for working with the {@link ListDocument} entity
 */

@Service
public class ListDocumentService {
    private final Logger logger = LoggerFactory.getLogger(ListDocumentService.class);
    private final ListDocumentRepository repository;
    private final TelegramBot telegramBot;

    public ListDocumentService(ListDocumentRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
    }

    /**
     * The method sends a list of documents to the telegram bot chat
     *
     * @param chatId
     */

    public void sendListDocuments(Long chatId, String text) {
        List<ListDocument> documents = repository.findByShelterName(text);
        try {
            for (ListDocument document : documents) {
                sendMessage(chatId, document.getDocument());
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
