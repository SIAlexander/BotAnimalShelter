package pro.sky.botanimalshelter.serviceTest;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.repository.PetRepository;
import pro.sky.botanimalshelter.service.PetService;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @Test
    public void testSendAllPetWhenPetsExist() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "Shelter1";
        List<Pet> pets = Arrays.asList(
                new Pet("Dog1", "Brown", new Date(chatId)),
                new Pet("Cat1", "White", new Date(chatId))
        );
        when(petRepository.findByShelterName(selectShelter)).thenReturn(pets);

        // Act
        petService.sendAllPet(chatId, selectShelter);

        // Assert
        verify(telegramBot, times(2)).execute(any(SendMessage.class));
    }

    @Test
    public void testSendAllPetWhenNoPetsExist() {
        // Arrange
        Long chatId = 1234L;
        String selectShelter = "Shelter2";
        when(petRepository.findByShelterName(selectShelter)).thenReturn(Collections.emptyList());

        // Act
        petService.sendAllPet(chatId, selectShelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "Информации о животных в приюте нет"));
    }
}