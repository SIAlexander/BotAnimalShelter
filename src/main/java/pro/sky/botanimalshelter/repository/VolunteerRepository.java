package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Volunteer;

import java.util.List;

/**
 * Repository for working with the {@link Volunteer} entity in the database
 */

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    /**
     * The method of finding a shelter in the database
     *
     * @param name
     * @return {@link List}
     */
    List<Volunteer> findByShelterName(String name);
}
