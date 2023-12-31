package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.HandlerRepository;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.volunteercrud.crudutils.HandlerDto;

import java.util.List;
import java.util.Optional;

/**
 * Service for working with the {@link Handler} entity
 */

/**
 * Сервис кинолога -- Dog trainer service
 */
@Service
public class HandlerService {
    private final Logger logger = LoggerFactory.getLogger(HandlerService.class);
    private final HandlerRepository repository;

    private final PetShelterRepository shelterRepository;
    private final TelegramBot telegramBot;

    public HandlerService(HandlerRepository repository, PetShelterRepository shelterRepository, TelegramBot telegramBot) {
        this.repository = repository;
        this.shelterRepository = shelterRepository;
        this.telegramBot = telegramBot;
    }

    /**
     * The method sends a list of handlers to the telegram bot chat
     *
     * @param chatId
     */
    /**
     * Сохраняем сущность кинолога -- Save dog trainer instance
     *
     * @param handler проверяется, что не пустой -- checked not null
     */
    public Handler saveHandler(Handler handler) {
        if (handler == null) {
            String errorMessage = "Экземпляр кинолог пустой -- Dog trainer instance is null";
            logger.info(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return repository.save(handler);
    }

    /**
     * Сохраняем сущность кинолога -- Save dog trainer instance
     *
     * @param name      проверяется, что не пустой -- checked not null
     * @param phone     проверяется, что не пустой -- checked not null
     * @param shelterId проверяется, существует ли приют с указанным идентификатором -- checked Pet Shelter exists
     */
    public Handler saveHandler(String name, String phone, long shelterId) {
        if (name.isEmpty() || phone.isEmpty()) {
            String errorMessage = "Dog trainer's name and/or phone missing";
            logger.info(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        PetShelter shelter = shelterRepository.findById(shelterId).orElse(null);

        if (shelter == null) {
            String errorMessage = "Приют с указанным id отсутствует -- Pet Shelter missing. Id: " + shelterId;
            logger.info(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        return saveHandler(new Handler(name, phone, shelter));
    }

    /**
     * Получаем кинолога из БД: экземпляр handler, если существует, или null, если нет <br>
     * Getting dog trainer from database: instance if exists or null if does not
     */
    public Handler findHandler(Handler handler) {
        Example<Handler> handlerExample = Example.of(handler);
        Optional<Handler> handlerOptional = repository.findOne(handlerExample);
        return handlerOptional.orElse(null);
    }

    public void deleteHandler(Handler handler) {
        repository.delete(handler);
    }

    /**
     * Удаляем кинолога по иденктификатор. Если экземпляр с таким идентификатором отсутствует, завершаем работу метода <br> Delete Dog Trainer instance by id. If instance with specified id missing then return to caller method
     */
    public Handler deleteHandlerById(long handlerId) {
        Optional<Handler> handlerOptional = repository.findById(handlerId);
        if (handlerOptional.isEmpty()) {
            return null;
        }
        Handler handlerDeleted = handlerOptional.get();
        repository.delete(handlerDeleted);
        return handlerDeleted;
    }

    /**
     * Просмотр списка кинологов -- View dog trainer list
     */

    public List<HandlerDto> findAllHandlers() {
        return repository.findAll()
                .stream().map(HandlerService::dto).toList();
    }

    public static HandlerDto dto(Handler handler) {
        if (handler == null) return null;
        return new HandlerDto(
                handler.getId(),
                handler.getName(),
                handler.getPhone(),
                checkShelterAndGetId(handler),
                checkShelterAndGetName(handler)
        );
    }

    private static Long checkShelterAndGetId(Handler handler) {
        PetShelter petShelter = handler.getShelter();
        if (petShelter == null) {
            return -1L;
        }
        return petShelter.getId();
    }

    private static String checkShelterAndGetName(Handler handler) {
        PetShelter petShelter = handler.getShelter();
        if (petShelter == null) {
            return "null shelter provided";
        }
        return petShelter.getName();
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
