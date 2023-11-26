package pro.sky.botanimalshelter.serviceTest;

import com.pengrad.telegrambot.TelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.repository.ReportUserCatShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserDogShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;
import pro.sky.botanimalshelter.service.ReportService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReportServiceTest {

    @Mock
    private ReportUserDogShelterRepository dogShelterRepository;

    @Mock
    private ReportUserCatShelterRepository catShelterRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TelegramBot telegramBot;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showReportNotificationCat() {
        // Arrange
        List<ReportUserCatShelter> catShelterList = new ArrayList<>();
        ReportUserCatShelter catShelter = new ReportUserCatShelter();
        catShelter.setUser(new User(1L,"Victor"));
        catShelter.setDateReport(Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).minusDays(2)));
        catShelterList.add(catShelter);

        when(catShelterRepository.findAll()).thenReturn(catShelterList);

        // Act
        reportService.showReportNotificationCat();

        // Assert
        verify(telegramBot, times(1)).execute(any());
    }

    @Test
    void showReportNotificationDog() {
        // Arrange
        List<ReportUserDogShelter> dogShelterList = new ArrayList<>();
        ReportUserDogShelter dogShelter = new ReportUserDogShelter();
        dogShelter.setUser(new User(1L,"Victor"));
        dogShelter.setDateReport(Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).minusDays(2)));

        dogShelterList.add(dogShelter);

        when(dogShelterRepository.findAll()).thenReturn(dogShelterList);

        // Act
        reportService.showReportNotificationDog();

        // Assert
        verify(telegramBot, times(1)).execute(any());
    }
}