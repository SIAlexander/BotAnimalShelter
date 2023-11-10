package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.BotLogRecord;

@Repository
public interface BotLog extends JpaRepository<BotLogRecord, Long> {
}
