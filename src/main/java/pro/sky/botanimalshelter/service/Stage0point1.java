package pro.sky.botanimalshelter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.model.Specimen;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.BotLog;
import pro.sky.botanimalshelter.repository.ShelterBook;
import pro.sky.botanimalshelter.repository.ShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

/** implementation Specification Stage 0 Point 1
 * <b>Specification:</b><br>
 *      Бот приветствует нового пользователя, рассказывает о себе и просит пользователя выбрать приют:
 *      <br>◦ Приют для кошек
 *      <br>◦ Приют для собак
 *      <br> Выбрать оба приюта нельзя. */
@Service
public class Stage0point1 {
    /** Welcome user
     * */

    private final Logger logger = LoggerFactory.getLogger(Stage0point1.class);
    private final UserRepository userRepository;

    private final ShelterRepository shelterRepository;

    private final ShelterBook shelterBook;

    private final BotLog botLog;

    private long startingShelter;

    @PostConstruct
            public void manageStartPetShelter(){

    }

    Stage0point1(UserRepository userRepository, ShelterRepository shelterRepository, ShelterBook shelterBook, BotLog botLog){
        this.userRepository = userRepository;
        this.shelterRepository = shelterRepository;
        this.shelterBook = shelterBook;
        this.botLog = botLog;
    }

    /** Welcoming rather new user, so his loved specimen is unknown yet
     * <br> We could create an initial pet shelter (kind of reception), or leave method as below */

    public ShelterMessage welcomeNewUser(){
        logger.info("New user welcome");
        return new ShelterMessage(0L, 0L, 0, 0, 0L,
                "Приветствие",
                "Здравствуйте! \n Выберите приют с питомцами Вашего любимого вида");
    }

    public User registerUser(long chatId, String userName, Specimen lovedSpecimen){
        if (userRepository.findByChatId(chatId)) {
            logger.info("User chatId " + chatId + ". Name = " + userName + "is already registered" );
            return null;}
        User newUser = new User();
        newUser.setName(userName);
        newUser.setChatId(chatId);
        newUser.setLovedSpecimen(lovedSpecimen);
        newUser = userRepository.save(newUser);

        return newUser;
    }

    public boolean findUser(User user){
        if(user == null) {return false;}
        Example<User> userExample = Example.of(user);
        Optional<User> actualUser = userRepository.findOne(userExample);
        return actualUser.isPresent();
    }


}
