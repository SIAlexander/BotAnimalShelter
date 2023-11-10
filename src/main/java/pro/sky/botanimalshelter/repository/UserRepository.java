package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.User;

import java.util.Optional;

/** storage for User objects representing Bot Users*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

Optional<User> findByChatId(long chatId);

//    Optional<User> getByChatId(long chatId);

}
