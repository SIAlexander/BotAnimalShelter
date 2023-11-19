package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.PetShelterRepository;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Service for working with the {@link PetShelter} entity
 */

@Service
public class PetShelterService {
    private final Logger logger = LoggerFactory.getLogger(PetShelterService.class);
    private final TelegramBot telegramBot;
    private final PetShelterRepository shelterRepository;

    public PetShelterService(TelegramBot telegramBot, PetShelterRepository shelterRepository) {
        this.telegramBot = telegramBot;
        this.shelterRepository = shelterRepository;
    }

    /**
     * The method sends the driving directions, contacts, and operating mode to the telegram bot chat
     *
     * @param chatId
     * @param text
     */

    public void sendDrivingDirections(Long chatId, String text) {
        PetShelter petShelter = shelterRepository.findByName(text);
        try {
            sendMessage(chatId, "Контактный телефон: " + petShelter.getPhone() + "\n" + "Режим работы:\n" + petShelter.getWorkSchedule());
            SendPhoto sendPhoto = new SendPhoto(chatId, new File(petShelter.getSchemesPath()).getAbsoluteFile());
            SendResponse response = telegramBot.execute(sendPhoto);
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }

    }

    /**
     * The method sends the security contacts to the telegram bot chat
     *
     * @param chatId
     * @param selectShelter
     */

    public void sendSecurityContact(Long chatId, String selectShelter) {
        PetShelter petShelter = shelterRepository.findByName(selectShelter);
        try {
            sendMessage(chatId, petShelter.getContactsSecurity());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method sends a story the shelter to the telegram bot chat
     *
     * @param chatId
     * @param selectShelter
     */

    public void sendStoryShelter(Long chatId, String selectShelter) {
        PetShelter petShelter = shelterRepository.findByName(selectShelter);
        try {
            sendMessage(chatId, petShelter.getStoryTheShelter());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    public PetShelter findShelter(String selectShelter) {
        return shelterRepository.findByName(selectShelter);
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

    /*Below are methods for managing pet shelters database */

    /**
     * Получаем список приютов домашних животных -- Get pet shelter list
     */
    public List<PetShelter> findAll() {
        return shelterRepository.findAll();
    }

    /**
     * Находим приют по идентификатору -- Find pet shelter by database identifier
     *
     * @param id идентификатор приюта в базе данных
     * @return возвращает экземпляр PetShelter или null, если приют с указанным идентификатором не существует -- Shelter instance with specified identifier or null if does not exist
     */
    public PetShelter findShelterById(long id) {
        Optional<PetShelter> petShelterOptional = shelterRepository.findById(id);
        return petShelterOptional.orElse(null);
    }

}
