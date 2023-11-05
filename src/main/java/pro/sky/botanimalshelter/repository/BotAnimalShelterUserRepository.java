package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.User;

@Repository
public interface BotAnimalShelterUserRepository extends JpaRepository<User, Long> {

}