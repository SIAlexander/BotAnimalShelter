package pro.sky.botanimalshelter.appservive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.repository.ShelterBook;

import java.util.Optional;

/** Выносим сюда рутинный повторяющийся код из классов выполнения команд бота (StageXpointY) */
public class AppServiceUtils {

    private final Logger logger = LoggerFactory.getLogger(AppServiceUtils.class);

    private final ShelterBook shelterBook;

    public AppServiceUtils(ShelterBook shelterBook) {
        this.shelterBook = shelterBook;
    }


    /** строка с сообщением для лога и исключения в случае, если в ShelterBook отсутствует 
     * сообщение пункта этапа бота
     * @param stage этап согласно ТЗ
     * @param point пункт этапа*/
    public static String messageMissing(int stage, int point){
        return "Отсутствует сообщение Этап " + stage + " пункт " + point;
    }

    /** Cтрока с сообщением для лога и исключения в случае, если в ShelterBook отсутствует
     * сообщение пункта этапа бота
     * @param stage этап согласно ТЗ
     * @param point пункт этапа
     * @param shelterId идентификатор приюта*/
    public static String messageMissing(int stage, int point, long shelterId){
        return "Отсутствует сообщение Этап " + stage + " пункт " + point + " идентификатор приюта " + shelterId;
    }

    public ShelterMessage readMessageFromShelterBook(int stage, int point, long shelterId){
        Optional<ShelterMessage> messageOptional = shelterBook.findByShelterIdAndStageAndPoint(shelterId, stage, point);
        if(messageOptional.isEmpty()){
            String string = messageMissing(stage, point, shelterId);
            logger.info(string);
            throw new RuntimeException(string);
        }
        return messageOptional.get();
    }
}
