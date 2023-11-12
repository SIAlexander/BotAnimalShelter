package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByChatId(Long chatId);

    User findByChatId(Long chatId);

}