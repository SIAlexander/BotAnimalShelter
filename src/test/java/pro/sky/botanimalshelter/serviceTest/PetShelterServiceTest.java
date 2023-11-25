package pro.sky.botanimalshelter.serviceTest;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.service.PetShelterService;

import static org.mockito.Mockito.*;
import java.io.File;

@RunWith(MockitoJUnitRunner.class)
public class PetShelterServiceTest {

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private PetShelterRepository shelterRepository;

    @InjectMocks
    private PetShelterService petShelterService;

    @Test
    public void testSendDrivingDirections() {
        // Arrange
        Long chatId = 1234L;
        String text = "Shelter1";
        PetShelter petShelter = new PetShelter("Shelter1", "123-456-7890", "Mon-Fri 9am-5pm", "path", "contacts", "story");
        when(shelterRepository.findByName(text)).thenReturn(petShelter);

        // Act
        petShelterService.sendDrivingDirections(chatId, text);

        // Assert
        String expectedMessage = "Контактный телефон: 123-456-7890\nРежим работы:\nMon-Fri 9am-5pm";
        verify(telegramBot).execute(new SendMessage(chatId, expectedMessage));
        verify(telegramBot).execute(new SendPhoto(chatId, new File(petShelter.getSchemesPath()).getAbsoluteFile()));
    }

    @Test
    public void testSendDrivingDirectionsWithInvalidText() {
        // Arrange
        Long chatId = 1234L;
        String text = "InvalidShelter";
        when(shelterRepository.findByName(text)).thenReturn(null);

        // Act
        petShelterService.sendDrivingDirections(chatId, text);

        // Assert
        verifyNoInteractions(telegramBot);
    }

    @Test
    public void testSendSecurityContactWithValidShelter() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "Shelter1";
        PetShelter petShelter = new PetShelter("Shelter1", "123-456-7890",
                "Monday-Friday 9:00-17:00", "path", "contacts", "story");
        when(shelterRepository.findByName(selectShelter)).thenReturn(petShelter);

        // Act
        petShelterService.sendSecurityContact(chatId, selectShelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "contacts"));
    }

    @Test
    public void testSendSecurityContactWithInvalidShelter() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "InvalidShelter";
        when(shelterRepository.findByName(selectShelter)).thenReturn(null);

        // Act
        petShelterService.sendSecurityContact(chatId, selectShelter);

        // Assert
        verifyNoInteractions(telegramBot);
    }

    @Test
    public void testSendStoryShelterWithValidShelter() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "Shelter1";
        PetShelter petShelter = new PetShelter("Shelter1", "123-456-7890", "Monday-Friday 9:00-17:00",
                "path", "contacts", "story");
        when(shelterRepository.findByName(selectShelter)).thenReturn(petShelter);

        // Act
        petShelterService.sendStoryShelter(chatId, selectShelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "story"));
    }

    @Test
    public void testSendStoryShelterWithInvalidShelter() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "InvalidShelter";
        when(shelterRepository.findByName(selectShelter)).thenReturn(null);

        // Act
        petShelterService.sendStoryShelter(chatId, selectShelter);

        // Assert
        verifyNoInteractions(telegramBot);
    }

    @Test
    public void testFindShelter() {
        // Arrange
        String selectShelter = "Shelter1";
    }
}