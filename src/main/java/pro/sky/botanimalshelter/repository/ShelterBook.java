package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ShelterMessage;
import java.util.List;
import java.util.Optional;

/** Repository for ShelterMessage objects representing Pet Shelter Information Messages*/
@Repository
public interface ShelterBook extends JpaRepository<ShelterMessage, Long> {

    /** returns Optional< ShelterMessage > accordingly to pet shelter, stage and point*/
    public Optional <ShelterMessage> findByShelterIdAndStageAndPoint(long shelterId, int stage, int point);

}
