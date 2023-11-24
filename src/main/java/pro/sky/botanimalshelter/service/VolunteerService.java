package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.Volunteer;
import pro.sky.botanimalshelter.repository.VolunteerRepository;
import pro.sky.botanimalshelter.volunteercrud.crudutils.VolunteerDto;

import java.util.List;

/**
 * Service for working with the {@link Volunteer} entity
 */

@Service
public class VolunteerService {
    private final Logger logger = LoggerFactory.getLogger(VolunteerService.class);

    private final VolunteerRepository repository;

    private final PetShelterService petShelterService;

    private final TelegramBot telegramBot;

    public VolunteerService(VolunteerRepository repository, PetShelterService petShelterService, TelegramBot telegramBot) {
        this.repository = repository;
        this.petShelterService = petShelterService;
        this.telegramBot = telegramBot;
    }

    /**
     * The method sends a list of volunteers to the telegram bot chat
     *
     * @param chatId
     * @param text
     */

    public void sendVolunteer(Long chatId, String text) {
        List<Volunteer> volunteers = repository.findByShelterName(text);
        try {
            for (Volunteer volunteer : volunteers) {
                sendMessage(chatId, volunteer.getName());
                sendMessage(chatId, volunteer.getPhone());
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

    public List<VolunteerDto> viewVolunteers() {
        return repository.findAll().stream()
                .map(VolunteerDto::dto).toList();
    }

    public VolunteerDto saveVolunteer(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            return null;
        }
        return VolunteerDto.dto(repository.save(VolunteerDto.volunteer(volunteerDto)));
    }

    public VolunteerDto update(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            return null;
        }

        PetShelter petShelter = petShelterService.findShelterById(volunteerDto.getShelterId());
        if (petShelter == null) {
            return null;
        }

        Volunteer volunteer = repository.findById(volunteerDto.getId()).orElse(null);
        if (volunteer == null) {
            return null;
        }

        return VolunteerDto.dto(repository.save(volunteer));
    }

    public VolunteerDto deleteVolunteer(Long id) {
        Volunteer volunteer = repository.findById(id).orElse(null);
        if (volunteer == null) {
            return null;
        }

        repository.delete(volunteer);

        return VolunteerDto.dto(volunteer);

    }

    public Volunteer findVolunteerById(Long volunteerId) {
        return repository.findById(volunteerId).orElse(null);
    }

    public Volunteer saveVolunteerEntity(Volunteer volunteer) {
        return repository.save(volunteer);
    }
}
