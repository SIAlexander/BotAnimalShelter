package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.BotLogRecord;

/** Журнал бота
 * <br>Нужен для реализации пунктов ТЗ, подразумевающих протяженные во времени процедуры (например, пробное усыновление)/>*/
@Repository
public interface BotLog extends JpaRepository<BotLogRecord, Long> {
}
