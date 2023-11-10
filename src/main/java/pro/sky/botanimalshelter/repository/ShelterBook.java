package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ShelterMessage;
import java.util.List;
import java.util.Optional;

/** База данных сообщений, выводимых ботом. Сообщения представлены моделью ShelterMessage */
@Repository
public interface ShelterBook extends JpaRepository<ShelterMessage, Long> {

    /** Ищем сообщение в базе данных сообщений (книге сообщений) приютов */
     public Optional <ShelterMessage> findByShelterIdAndStageAndPoint(long shelterId, int stage, int point);

}
