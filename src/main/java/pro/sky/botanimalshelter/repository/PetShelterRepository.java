package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.model.PetShelter;

/**
 * Repository for working with the {@link PetShelter} entity in the database
 */

@Repository
public interface PetShelterRepository extends JpaRepository<PetShelter, Long> {
    /**
     * The method of finding a pet shelter in the database
     * @param name
     * @return {@link PetShelter}
     */
    PetShelter findByName(String name);
}
