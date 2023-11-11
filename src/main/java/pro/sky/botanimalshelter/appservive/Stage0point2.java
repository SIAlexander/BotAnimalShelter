package pro.sky.botanimalshelter.appservive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.repository.ShelterBook;

import java.util.Optional;


/**
 * Выполняем команды Этапа 0 пункта 2
 */
@Service
public class Stage0point2 {

    private final Logger logger = LoggerFactory.getLogger(Stage0point2.class);

    private final ShelterBook shelterBook;

    public Stage0point2(ShelterBook shelterBook) {
        this.shelterBook = shelterBook;
    }

    /**
     * Этап 0, пункт 1. Поднимаем сообщение с информацией о приюте
     */
    public ShelterMessage getShelterInfo(long shelterId) {
        Optional<ShelterMessage> messageOptional = shelterBook.findByShelterIdAndStageAndPoint(shelterId, 0, 2);

        if (messageOptional.isEmpty()) {
            String string = AppServiceUtils.messageMissing(0, 2);
            logger.info(string);
            throw new RuntimeException(string);
        }

        return messageOptional.get();
    }
}
