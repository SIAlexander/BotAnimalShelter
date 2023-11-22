package pro.sky.botanimalshelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
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

    public List<ReportUserDogShelter> getDogShelterReports() {
        return reportUserDogShelterRepository.findAll();
    }

    /**
     * Create and save new dog life condition report
     *
     * @param report nullable
     * @return saved ReportUserDogShelter entity or null if null argument provided
     */
    public ReportUserDogShelter uploadDogShelterReport(ReportUserDogShelter report) {
        if (report == null) {
            return null;
        }
        return reportUserDogShelterRepository.save(report);
    }

    public ReportUserDogShelter findDogReportById(Long id) {
        return reportUserDogShelterRepository.findById(id).orElse(null);
    }

    public ReportUserCatShelter findCatReportById(Long id) {
        return reportUserCatShelterRepository.findById(id).orElse(null);
    }

    public ReportUserDogShelter updateReportDog(ReportUserDogShelter report) {
        if (report == null) {
            return null;
        }
        ReportUserDogShelter reportUpdated = findDogReportById(report.getId());
        if (reportUpdated == null) {
            return null;
        }
        reportUpdated = reportUserDogShelterRepository.save(reportUpdated);
        return reportUpdated;
    }

    public ReportUserDogShelter deleteReportUserDogShelter(Long reportId) {
        ReportUserDogShelter reportUserDogShelter = findDogReportById(reportId);
        if (reportUserDogShelter == null) {
            return null;
        }
        reportUserDogShelterRepository.delete(reportUserDogShelter);
        return reportUserDogShelter;
    }

    public List<ReportUserCatShelter> getCatShelterReports() {
        return reportUserCatShelterRepository.findAll();
    }

    public ReportUserCatShelter uploadCatShelterReport(ReportUserCatShelter report) {
        if (report == null) {
            return null;
        }
        return reportUserCatShelterRepository.save(report);
    }

    public ReportUserCatShelter updateReportCat(ReportUserCatShelter report) {
        if (report == null) {
            return null;
        }
        ReportUserCatShelter reportUpdated =
                reportUserCatShelterRepository.findById(report.getId()).orElse(null);
        return reportUpdated;
    }

    public ReportUserCatShelter deleteReportUserCatShelter(Long id) {
        ReportUserCatShelter deletedReport = findCatReportById(id);
        if (deletedReport == null) {
            return null;
        }
        reportUserCatShelterRepository.delete(deletedReport);
        return deletedReport;
    }
}
