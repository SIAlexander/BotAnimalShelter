package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.Volunteer;
import pro.sky.botanimalshelter.repository.HandlerRepository;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.repository.VolunteerRepository;
import pro.sky.botanimalshelter.volunteercrud.crudutils.HandlerDto;
import pro.sky.botanimalshelter.volunteercrud.crudutils.PetShelterDto;
import pro.sky.botanimalshelter.volunteercrud.crudutils.VolunteerDto;

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

    private final VolunteerRepository volunteerRepository;

    private final HandlerRepository handlerRepository;

    public PetShelterService(TelegramBot telegramBot, PetShelterRepository shelterRepository, VolunteerRepository volunteerRepository, HandlerRepository handlerRepository) {
        this.telegramBot = telegramBot;
        this.shelterRepository = shelterRepository;
        this.volunteerRepository = volunteerRepository;
        this.handlerRepository = handlerRepository;
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

    /**
     * Сохраняем сущность приюта
     *
     * @param petShelter сохраняемая сущность, проверяется на null -- entity to be saved, nullable
     */
    public PetShelter save(PetShelter petShelter) {
        if (petShelter == null) {
            logger.info("Задана пустая сущность приюта для животных -- Empty PetShelter entity specified");
            return null;
        }
        return shelterRepository.save(petShelter);
    }

    /**
     * Сохраняем сущность PetShelter -- Save PetShelter entity
     *
     * @param petShelterDTO объект для передачи параметров сущности PetShelter
     * @return сущность PetShelter
     */
    public PetShelter save(PetShelterDto petShelterDTO) {

        if (petShelterDTO == null) {
            String errorMessage = "Пустой DTO -- Empty DTO";
            logger.info(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        PetShelter petShelter = PetShelterDto.toPetShelter(petShelterDTO);

        petShelter = save(petShelter);

        return petShelter;
    }

    public PetShelter deleteById(Long id) {
        PetShelter petShelter = findShelterById(id);
        if (petShelter == null) {
            return null;
        }
        shelterRepository.deleteById(id);
        return petShelter;
    }


    public List<Volunteer> getVolunteers(PetShelter shelter) {
        if (shelter == null) {
            return null;
        }
        return volunteerRepository.findByShelterName(shelter.getName());
    }

    public List<VolunteerDto> getVolunteers(Long shelterId) {
        PetShelter shelter = findShelterById(shelterId);
        if (shelter == null) {
            return null;
        }

        return getVolunteers(shelter).stream()
                .map(VolunteerDto::dto).toList();
    }

    /**
     * @param shelterId   проверяется, имеется ли такой приют животных
     * @param volunteerId проверяется, имеется ли волонтер с указанным id
     * @return
     */
    public String enrollVolunteer(Long shelterId, Long volunteerId) {

        PetShelter shelter = findShelterById(shelterId);
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElse(null);

        String resultMessage = "";

        if (shelter == null || volunteer == null) {
            resultMessage = "Задан пустой приют и/или волонтер";
        } else {
//                if (getVolunteers(shelter) == null) {
//                    shelter.setVolunteers(new ArrayList<>());
//                }
//                shelter.getVolunteers().add(volunteer);*/
            volunteer.setShelter(shelter);
            volunteerRepository.save(volunteer);
            resultMessage = "Приют " + PetShelterDto.toDto(shelter) +
                    " принял волонтера " + VolunteerDto.dto(volunteer);

            return resultMessage;
        }
        return resultMessage;
    }

    public List<HandlerDto> getHandlers(Long petShelterId) {
        PetShelter shelter = findShelterById(petShelterId);
        if (shelter == null) {
            return null;
        }
        if (shelter.getName().isEmpty()) {
            return null;
        }
        return handlerRepository.findByShelterName(shelter.getName())
                .stream().map(HandlerService::dto).toList();
    }
}
