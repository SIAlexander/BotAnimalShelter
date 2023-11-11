package pro.sky.botanimalshelter.appservive;

import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.PetCareReport;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.repository.PetCareReportRepository;

@Service
public class Stage0point4 {

    private final AppServiceUtils appServiceUtils;

    private final PetCareReportRepository reportRepository;

    public Stage0point4(AppServiceUtils appServiceUtils, PetCareReportRepository reportRepository) {
        this.appServiceUtils = appServiceUtils;
        this.reportRepository = reportRepository;
    }

    public ShelterMessage getInvitationToSendAdopterReport(long shelterId) {
        return appServiceUtils.readMessageFromShelterBook(0, 4, shelterId);
    }

    public PetCareReport savePetCareReport(PetCareReport petCareReport) {
        return reportRepository.save(petCareReport);
    }

}
