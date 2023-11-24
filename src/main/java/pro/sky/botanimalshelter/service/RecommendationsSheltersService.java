package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.RecommendationsShelters;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.repository.RecommendationsSheltersRepository;
import pro.sky.botanimalshelter.volunteercrud.crudutils.RecommendationsSheltersDto;

import java.util.List;

/**
 * Service for working with the {@link RecommendationsShelters} entity
 */

@Service
public class RecommendationsSheltersService {
    private final Logger logger = LoggerFactory.getLogger(RecommendationsSheltersService.class);
    private final RecommendationsSheltersRepository repository;

    private final PetShelterRepository shelterRepository;
    private final TelegramBot telegramBot;

    public RecommendationsSheltersService(RecommendationsSheltersRepository repository, PetShelterRepository shelterRepository, TelegramBot telegramBot) {
        this.repository = repository;
        this.shelterRepository = shelterRepository;
        this.telegramBot = telegramBot;
    }

    /**
     * The method of sending a dating rules to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendDatingRules(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getDatingRules());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }

    }

    /**
     * The method of sending a recommendations transportation to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendRecommendationsTransportation(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getAnimalTransportation());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method of sending a recommendations home improvement to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendRecommendationsHomeImprovement(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getHomeImprovement());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method of sending a recommendations home adult animal to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendRecommendationsHomeAdultAnimal(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getHomeImprovementAdultAnimal());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method of sending a recommendations home disabilities to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendRecommendationsHomeDisabilities(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getHomeImprovementAnimalWithDisabilities());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method of sending a refuse not you up to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendRefuseNotYouUp(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getListReasonsRefuseAndNotUpAnimal());
        } catch (NullPointerException e) {
            logger.info("information from DB is empty");
        }
    }

    /**
     * The method of sending a communication dog to the telegram  bot chat
     *
     * @param chatId
     * @param shelter
     */

    public void sendCommunicationDog(Long chatId, String shelter) {
        RecommendationsShelters recommendations = repository.findByShelterName(shelter);
        try {
            sendMessage(chatId, recommendations.getRecommendationsHandler());
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

    public List<RecommendationsShelters> viewRecommendations() {
        return repository.findAll();
    }

    public List<RecommendationsShelters> getRecommendationsShelters(Long shelterId) {

        PetShelter petShelter = shelterRepository.findById(shelterId).orElse(null);
        if (petShelter == null) {
            return null;
        }
        return repository.findAllByShelter(petShelter);
    }

    /**
     * @param recommendationsSheltersDto nullable
     * @return saved entity or null
     */
    public RecommendationsShelters save(RecommendationsSheltersDto recommendationsSheltersDto) {
        if (recommendationsSheltersDto == null) {
            return null;
        }
        PetShelter shelter = shelterRepository.findById(recommendationsSheltersDto.getShelterId()).orElse(null);
        if (shelter == null) {
            return null;
        }
        return repository.save(new RecommendationsShelters(
                recommendationsSheltersDto.getId(),
                recommendationsSheltersDto.getName(), recommendationsSheltersDto.getDatingRules(),
                recommendationsSheltersDto.getAnimalTransportation(), recommendationsSheltersDto.getHomeImprovement(),
                recommendationsSheltersDto.getHomeImprovementAdultAnimal(),
                recommendationsSheltersDto.getHomeImprovementAnimalWithDisabilities(),
                recommendationsSheltersDto.getListReasonsRefuseAndNotUpAnimal(),
                recommendationsSheltersDto.getRecommendationsHandler(),
                shelter));
    }
}
