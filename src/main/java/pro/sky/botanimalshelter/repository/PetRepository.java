package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Pet;

import java.util.List;

/**
 * Repository for working with the {@link Pet} entity in the database
 */

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * The method of finding a shelter in the database
     *
     * @param name
     * @return {@link List}
     */

    List<Pet> findByShelterName(String name);

}
