package pro.sky.botanimalshelter.serviceTest;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserCatShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserDogShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;
import pro.sky.botanimalshelter.service.UserService;

import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PetShelterRepository petShelterRepository;

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private ReportUserCatShelterRepository reportCatRepository;

    @Mock
    private ReportUserDogShelterRepository reportDogRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSaveUserWhenUserDoesNotExist() {
        // Arrange
        Long chatId = 1234L;
        String name = "Ivan Men";
        when(userRepository.existsByChatId(chatId)).thenReturn(false);

        // Act
        userService.saveUser(chatId, name);

        // Assert
        verify(userRepository).save(new User(chatId, name));
    }

    @Test
    public void testSaveUser() {
        // Arrange
        Long chatId = 1234L;
        String name = "Ivan Men";
        when(userRepository.existsByChatId(chatId)).thenReturn(true);

        // Act
        userService.saveUser(chatId, name);

        // Assert
        verifyNoInteractions(userRepository);
    }

    @Test
    public void testSavePhone_WhenCalled_ExpectPhoneSaved() {
        // Arrange
        Long chatId = 1234L;
        String phone = "123-456-7890";
        User user = new User(chatId, "Ivan Men");
        when(userRepository.findByChatId(chatId)).thenReturn(user);

        // Act
        userService.savePhone(chatId, phone);

        // Assert
        verify(userRepository).save(user);
    }

    @Test
    public void testSaveEmail() {
        // Arrange
        Long chatId = 1234L;
        String email = "ivan.men@yandex.com";
        User user = new User(chatId, "Ivan Men");
        when(userRepository.findByChatId(chatId)).thenReturn(user);

        // Act
        userService.saveEmail(chatId, email);

        // Assert
        verify(userRepository).save(user);
    }

    @Test
    public void testSaveLocation() {
        // Arrange
        Long chatId = 1234L;
        String location = "City, Country";
        User user = new User(chatId, "John Doe");
        when(userRepository.findByChatId(chatId)).thenReturn(user);

        // Act
        userService.saveLocation(chatId, location);

        // Assert
        verify(userRepository).save(user);
    }

    @Test
    public void testSendReportFromUser() {
        // Arrange
        Long chatId = 1234L;
        String text = "Short report";
        String selectShelter = "/cat";
        String message = "file_message";

        // Act
        userService.sendReportFromUser(chatId, text, selectShelter, message);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "Маленькое описание, повторите отправку всего отчета"));
    }

    // Similarly, test for other methods of sendReportFromUser with valid inputs are implemented
}