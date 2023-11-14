package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.RecommendationsShelters;

import java.util.List;

/**
 * Repository for working with the {@link RecommendationsShelters} entity in the database
 */

@Repository
public interface RecommendationsSheltersRepository extends JpaRepository<RecommendationsShelters, Long> {
    /**
     * The method of finding a shelter in the database
     * @param name
     * @return {@link RecommendationsShelters}
     */
    RecommendationsShelters findByShelterName(String name);
}
