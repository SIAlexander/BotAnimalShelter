package pro.sky.botanimalshelter.repository;

import com.pengrad.telegrambot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotAnimalShelterUserRepository extends JpaRepository<User,Long> {
}
