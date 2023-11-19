package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.repository.PetRepository;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PetService {
    private final TelegramBot telegramBot;
    private final PetRepository petRepository;

    public PetService(TelegramBot telegramBot, PetRepository petRepository) {
        this.telegramBot = telegramBot;
        this.petRepository = petRepository;
    }

    /**
     * Method for the withdrawal of all animals in shelters
     *
     * @param chatId
     * @param selectShelter
     */

    public void sendAllPet(Long chatId, String selectShelter) {
        List<Pet> pets = petRepository.findByShelterName(selectShelter);
        if (pets.isEmpty()) {
            sendMessage(chatId, "Инормации о животных в приюте нет");
        }
        for (Pet pet : pets) {
            sendMessage(chatId, "Кличка: " + pet.getName() +
                    "\nЦвет: " + pet.getColor() +
                    "\nДата рождения: " + new SimpleDateFormat("yyyy-MM-dd").format(pet.getBirthDate()));
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
