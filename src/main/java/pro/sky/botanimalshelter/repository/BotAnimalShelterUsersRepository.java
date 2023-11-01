package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Users;
@Repository
public interface BotAnimalShelterUsersRepository extends JpaRepository<Users, Long> {

}
