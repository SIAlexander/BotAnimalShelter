package pro.sky.botanimalshelter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.listener.BotAnimalShelterUpdatesListener;
import pro.sky.botanimalshelter.repository.BotAnimalShelterUserRepository;
@Service
public class BotAnimalShelterService {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);
    private final BotAnimalShelterUserRepository repository;

    public BotAnimalShelterService(BotAnimalShelterUserRepository repository) {
        this.repository = repository;
    }
}
