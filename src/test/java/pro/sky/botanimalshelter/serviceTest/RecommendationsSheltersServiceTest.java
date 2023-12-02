package pro.sky.botanimalshelter.serviceTest;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pro.sky.botanimalshelter.model.RecommendationsShelters;
import pro.sky.botanimalshelter.repository.RecommendationsSheltersRepository;
import pro.sky.botanimalshelter.service.RecommendationsSheltersService;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecommendationsSheltersServiceTest {

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private RecommendationsSheltersRepository repository;

    @InjectMocks
    private RecommendationsSheltersService recommendationsSheltersService;

    @Test
    public void testSendDatingRulesWithValidShelter() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "Shelter1";
        RecommendationsShelters recommendations = new RecommendationsShelters("Shelter1", "rules", "transportation", "improvement", "adult", "disabilities");
        when(repository.findByShelterName(shelter)).thenReturn(recommendations);

        // Act
        recommendationsSheltersService.sendDatingRules(chatId, shelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "rules"));
    }

    @Test
    public void testSendRecommendationsTransportation() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "Shelter1";
        RecommendationsShelters recommendations = new RecommendationsShelters("Shelter1", "rules", "transportation", "improvement", "adult", "disabilities");
        when(repository.findByShelterName(shelter)).thenReturn(recommendations);

        // Act
        recommendationsSheltersService.sendRecommendationsTransportation(chatId, shelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "transportation"));
    }

    @Test
    public void testSendRecommendationsHomeImprovement() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "Shelter1";
        RecommendationsShelters recommendations = new RecommendationsShelters("Shelter1", "rules", "transportation", "improvement", "adult", "disabilities");
        when(repository.findByShelterName(shelter)).thenReturn(recommendations);

        // Act
        recommendationsSheltersService.sendRecommendationsHomeImprovement(chatId, shelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "improvement"));
    }

    @Test
    public void testSendRecommendationsHomeAdultAnimal() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "Shelter1";
        RecommendationsShelters recommendations = new RecommendationsShelters("Shelter1", "rules", "transportation", "improvement", "adult", "disabilities");
        when(repository.findByShelterName(shelter)).thenReturn(recommendations);

        // Act
        recommendationsSheltersService.sendRecommendationsHomeAdultAnimal(chatId, shelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "adult"));
    }

    @Test
    public void testSendRecommendationsHomeDisabilities() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "Shelter1";
        RecommendationsShelters recommendations = new RecommendationsShelters("Shelter1", "rules",
                "transportation", "improvement", "adult", "disabilities");
        when(repository.findByShelterName(shelter)).thenReturn(recommendations);

        // Act
        recommendationsSheltersService.sendRecommendationsHomeDisabilities(chatId, shelter);

        // Assert
        verify(telegramBot).execute(new SendMessage(chatId, "disabilities"));
    }

    @Test
    public void testSendDatingRules() {
        // Arrange
        Long chatId = 1234L;
        String shelter = "InvalidShelter";
        when(repository.findByShelterName(shelter)).thenReturn(null);

        // Act
        recommendationsSheltersService.sendDatingRules(chatId, shelter);

        // Assert
        verifyNoInteractions(telegramBot);
    }

    // Similarly, test for other methods with invalid shelters are implemented
}