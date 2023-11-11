package pro.sky.botanimalshelter.appservive;

import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.repository.BotLog;

@Service
public class Stage0point4 {

    private final AppServiceUtils appServiceUtils;


    public Stage0point4(AppServiceUtils appServiceUtils) {
        this.appServiceUtils = appServiceUtils;
    }

    public ShelterMessage getInvitationToSendAdopterReport(long shelterId){
        return appServiceUtils.readMessageFromShelterBook(0,4, shelterId);
    }

}
