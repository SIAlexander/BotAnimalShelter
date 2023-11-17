package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.repository.ReportUserCatShelterRepository;
import pro.sky.botanimalshelter.repository.ReportUserDogShelterRepository;
import pro.sky.botanimalshelter.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Service for working with the {@link ReportUserCatShelter} and {@link ReportUserDogShelter} entity
 */

@Service
public class ReportService {
    private final ReportUserDogShelterRepository reportUserDogShelterRepository;
    private final ReportUserCatShelterRepository reportUserCatShelterRepository;
    private final UserRepository userRepository;
    private final TelegramBot telegramBot;

    public ReportService(ReportUserDogShelterRepository reportUserDogShelterRepository, ReportUserCatShelterRepository reportUserCatShelterRepository, UserRepository userRepository, TelegramBot telegramBot) {
        this.reportUserDogShelterRepository = reportUserDogShelterRepository;
        this.reportUserCatShelterRepository = reportUserCatShelterRepository;
        this.userRepository = userRepository;
        this.telegramBot = telegramBot;
    }

    /**
     * Method for sending a report dog reminder
     */

    @Scheduled(cron = "0 0/1 * * * *")
    public void showReportNotificationCat() {
        Timestamp localDateTime = Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).minusDays(2));
        List<ReportUserCatShelter> reportUserCatShelterList = reportUserCatShelterRepository.findAll();
        for (ReportUserCatShelter reportUserCatShelter : reportUserCatShelterList) {
            if (localDateTime.equals(reportUserCatShelter.getDateReport())) {
                sendMessage(reportUserCatShelter.getUser().getChatId(), "Отправьте отчет");
            }
        }
    }

    /**
     * Method for sending a report dog reminder
     */

    @Scheduled(cron = "0 0/1 * * * *")
    public void showReportNotificationDog() {
        Timestamp localDateTime = Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).minusDays(2));
        List<ReportUserDogShelter> reportUserDogShelterList = reportUserDogShelterRepository.findAll();
        for (ReportUserDogShelter reportUserDogShelter : reportUserDogShelterList) {
            if (localDateTime.equals(reportUserDogShelter.getDateReport())) {
                sendMessage(reportUserDogShelter.getUser().getChatId(), "Отправьте отчет");
            }
        }
    }

    /**
     * The method of sending a message to the telegram  bot chat
     *
     * @param chatId
     * @param text
     */

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        telegramBot.execute(sendMessage);
    }
}
