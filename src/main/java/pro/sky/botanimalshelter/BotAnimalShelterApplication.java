package pro.sky.botanimalshelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BotAnimalShelterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotAnimalShelterApplication.class, args);
    }
}
