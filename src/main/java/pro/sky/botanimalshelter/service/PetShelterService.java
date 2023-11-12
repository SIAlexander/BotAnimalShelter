package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.PetShelterRepository;

import java.io.File;

@Service
public class PetShelterService {
    private final Logger logger = LoggerFactory.getLogger(PetShelterService.class);
    private final TelegramBot telegramBot;
    private final PetShelterRepository shelterRepository;

    public PetShelterService(TelegramBot telegramBot, PetShelterRepository shelterRepository) {
        this.telegramBot = telegramBot;
        this.shelterRepository = shelterRepository;
    }

    public void sendDrivingDirections(Long chatId, String text) {
        PetShelter petShelter = shelterRepository.findByName(text);
        try {
            sendMessage(chatId, "Контактный телефон: " + petShelter.getPhone() + "\n" + "Режим работы:\n" + petShelter.getWorkSchedule());
            SendPhoto sendPhoto = new SendPhoto(chatId, new File(petShelter.getSchemesPath()).getAbsoluteFile());
            SendResponse response = telegramBot.execute(sendPhoto);
        } catch (NullPointerException e){
            logger.info("information from DB is empty");
        }

    }

    public void sendSecurityContact(Long chatId, String shelter) {
        PetShelter petShelter = shelterRepository.findByName(shelter);
        try {
            sendMessage(chatId, petShelter.getContactsSecurity());
        }catch (NullPointerException e){
            logger.info("information from DB is empty");
        }
    }

    public void sendStoryShelter(Long chatId, String shelter){
        PetShelter petShelter = shelterRepository.findByName(shelter);
        try {
            sendMessage(chatId, petShelter.getStoryTheShelter());
        }catch (NullPointerException e){
            logger.info("information from DB is empty");
        }
    }

    public PetShelter findShelter(String selectShelter){
        return shelterRepository.findByName(selectShelter);
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        telegramBot.execute(sendMessage);
    }
}
