package pro.sky.botanimalshelter.service;

import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.Users;
import pro.sky.botanimalshelter.repository.BotAnimalShelterUsersRepository;

@Service
public class BotAnimalShelterService {

    private final BotAnimalShelterUsersRepository botAnimalShelterUsersRepository;

    public BotAnimalShelterService(BotAnimalShelterUsersRepository botAnimalShelterUsersRepository) {
        this.botAnimalShelterUsersRepository = botAnimalShelterUsersRepository;
    }


    public void saveUsers(Long idChat, String userName) {
        Users users = new Users(idChat, userName);
        botAnimalShelterUsersRepository.save(users);
    }
}
