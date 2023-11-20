package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;

/**
 * Repository for working with the {@link ReportUserDogShelter} entity in the database
 */

@Repository
public interface ReportUserDogShelterRepository extends JpaRepository<ReportUserDogShelter, Long> {
}
