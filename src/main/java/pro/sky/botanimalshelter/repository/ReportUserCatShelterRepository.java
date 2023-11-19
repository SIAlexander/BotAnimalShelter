package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.RecommendationsShelters;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;

/**
 * Repository for working with the {@link ReportUserCatShelter} entity in the database
 */
@Repository
public interface ReportUserCatShelterRepository extends JpaRepository<ReportUserCatShelter, Long> {

}
