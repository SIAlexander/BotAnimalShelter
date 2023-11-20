package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.RecommendationsShelters;
import pro.sky.botanimalshelter.model.User;

/**
 * Repository for working with the {@link User} entity in the database
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Checks if there is a user in the database
     * @param chatId
     * @return {@link Boolean}
     */
    boolean existsByChatId(Long chatId);

    /**
     * The method of finding a user in the database
     * @param chatId
     * @return {@link User}
     */
    User findByChatId(Long chatId);

}
