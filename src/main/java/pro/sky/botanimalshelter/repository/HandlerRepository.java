package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Handler;

import java.util.List;

/**
 * Repository for working with the {@link Handler} entity in the database
 */
@Repository
public interface HandlerRepository extends JpaRepository<Handler, Long> {
    /**
     * The method of finding a shelter in the database
     *
     * @param name
     * @return {@link List}
     */
    List<Handler> findByShelterName(String name);
}
