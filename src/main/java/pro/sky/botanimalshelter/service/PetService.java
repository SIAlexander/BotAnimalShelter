package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.repository.PetRepository;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    /**
     * @param id
     * @return возвращает сущность Pet или null, если экземпляр с указанным идентификатором не найден --
     * Pet entity with specified ID or null if entity is not found
     */
    public Pet findById(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);
        Pet pet = null;
        if (petOptional.isPresent()) {
            pet = petOptional.get();
        }
        return pet;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    /**
     * @param id идентификатор сущности питомца Pet -- Pet entity identifier
     * @return Возвращает удаленную сущность или null, если сущность с указанным идентификатором не существовала в момент выполнения метода --Deleted entity or null if entity with specified Id was not found
     */
    public Pet deletePet(Long id) {
        if (id == null) {
            return null;
        }
        Pet pet = findById(id);
        if (pet == null) {
            return null;
        }
        petRepository.delete(pet);
        return pet;
    }

}
