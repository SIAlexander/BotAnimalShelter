package pro.sky.botanimalshelter.appservive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.model.Specimen;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.BotLog;
import pro.sky.botanimalshelter.repository.ShelterBook;
import pro.sky.botanimalshelter.repository.ShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;

import java.util.Optional;

/**
 * implementation Specification Stage 0 Point 1
 * <b>Specification:</b><br>
 * Бот приветствует нового пользователя, рассказывает о себе и просит пользователя выбрать приют:
 * <br>◦ Приют для кошек
 * <br>◦ Приют для собак
 * <br> Выбрать оба приюта нельзя.
 */
@Service
public class Stage0point1 {
    /**
     * Welcome user
     */

    private final Logger logger = LoggerFactory.getLogger(Stage0point1.class);
    private final UserRepository userRepository;

    private final ShelterRepository shelterRepository;

    private final ShelterBook shelterBook;

    private final BotLog botLog;


    Stage0point1(UserRepository userRepository, ShelterRepository shelterRepository, ShelterBook shelterBook, BotLog botLog) {
        this.userRepository = userRepository;
        this.shelterRepository = shelterRepository;
        this.shelterBook = shelterBook;
        this.botLog = botLog;
    }

    /**
     * Welcoming rather new user, so his loved specimen is unknown yet
     * <br> We could create an initial pet shelter (kind of reception), or leave method as below
     */

    public ShelterMessage welcomeNewUser() {
        logger.info("Этап 0 пункт 1 Приветствуем нового пользователя");
        Optional<ShelterMessage> shelterMessageOptional =
                shelterBook.findByShelterIdAndStageAndPoint(0, 0, 0);
        if (shelterMessageOptional.isPresent()) {
            return shelterMessageOptional.get();
        }
        String string = AppServiceUtils.messageMissing(0, 0);
        logger.info(string);
        throw new RuntimeException(string);
    }

    /**
     * Регистрируем (сохраняем в базе данных) нового пользователя <br> Возвращаем контейнер Optional с
     * сущностью нового пользователя.
     * <br>Если пользователь уже имеется в базе, возвращаем пустой контейнер
     */
    public Optional<User> registerUser(long chatId, String userName, Specimen lovedSpecimen) {

        Optional<User> userOptional = userRepository.findByChatId(chatId);

        if (userOptional.isPresent()) {
            logger.info("Пользователь " + userOptional.get() + " уже зарегистрирован");
            return Optional.empty();
        }
        User newUser = new User();
        newUser.setName(userName);
        newUser.setChatId(chatId);
        newUser.setLovedSpecimen(lovedSpecimen);
        newUser = userRepository.save(newUser);
        logger.info("Зарегистрирован пользователь: " + newUser);

        return Optional.of(newUser);
    }


}
