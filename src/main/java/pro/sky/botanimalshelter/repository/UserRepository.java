package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.User;

/** storage for User objects representing Bot Users*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByChatId(long chatId);
}
