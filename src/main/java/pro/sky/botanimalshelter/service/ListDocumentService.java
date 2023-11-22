package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.ListDocumentRepository;
import pro.sky.botanimalshelter.volunteercrud.crudutils.ListDocumentDto;

import java.util.List;
import java.util.Optional;

/**
 * Service for working with the {@link ListDocument} entity
 */

@Service
public class ListDocumentService {
    private final Logger logger = LoggerFactory.getLogger(ListDocumentService.class);
    private final ListDocumentRepository repository;

    private final PetShelterService petShelterService;
    private final TelegramBot telegramBot;

    public ListDocumentService(ListDocumentRepository repository, PetShelterService petShelterService, TelegramBot telegramBot) {
        this.repository = repository;
        this.petShelterService = petShelterService;
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

    /**
     * Получаем список всех ListDocument из базы данных -- Get all ListDocument entities from database
     *
     * @return список сущностей ListDocument
     */
    public List<ListDocument> findAllListDocuments() {
        return repository.findAll();
    }

    /**
     * Получаем сущность ListDocument по идентификатору базы данных -- find ListDocument by database identifier
     *
     * @param id ListDocument -- ListDocument entity database identifier
     * @return сущность ListDocument или null, если сущность с указанным идентификатором не существует -- ListDocument entity or null if entity does not exist
     */
    public ListDocument findById(Long id) {
        Optional<ListDocument> listDocumentOptional = repository.findById(id);
        return listDocumentOptional.orElse(null);
    }

    /**
     * Создаем документ ListDocument и сохраняем в базе данных -- Create ListDocument entity and save with database
     *
     * @param listDocumentDto nullable
     * @return Сущность ListDocument в случае успешного сохранения или null,
     * если получен пустой аргумент, или содержащий неправильный идентификатор приюта
     * <br>ListDocument entity if saved succefully. Null if listDocumentDto argument is null or contains wrong shelter identifier
     */
    public ListDocumentDto createListDocument(ListDocumentDto listDocumentDto) {
        if (listDocumentDto == null) {
            return null;
        }
        Long id = listDocumentDto.getId();
        String document = listDocumentDto.getDocument();
        Long shelterId = listDocumentDto.getShelterId();
        PetShelter petShelter = petShelterService.findShelterById(shelterId);
        if (petShelter == null) {
            return null;
        }

        ListDocument listDocument = new ListDocument(document, petShelter);
        listDocument = repository.save(listDocument);
        return ListDocumentDto.dto(listDocument);
    }

    public ListDocumentDto updateListDocument(Long id, ListDocumentDto listDocumentDto) {
        if (listDocumentDto == null) {
            return null;
        }

        ListDocument listDocument = repository.findById(id).orElse(null);
        if (listDocument == null) {
            return null;
        }

        String document = listDocumentDto.getDocument();
        Long shelterId = listDocumentDto.getShelterId();
        PetShelter petShelter = petShelterService.findShelterById(shelterId);
        if (petShelter == null) {
            return null;
        }

        listDocument.setDocument(document);
        listDocument.setShelter(petShelter);
        listDocument = repository.save(listDocument);
        return ListDocumentDto.dto(listDocument);
    }

    public ListDocumentDto deleteListDocument(Long id) {
        ListDocument listDocument = findById(id);
        if (listDocument == null) {
            return null;
        }
        ListDocumentDto listDocumentDto = ListDocumentDto.dto(listDocument);
        repository.delete(listDocument);
        return listDocumentDto;
    }
}
