package pro.sky.botanimalshelter.appservive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.botanimalshelter.model.ShelterMessage;

@Service
public class Stage0point3 {

    @Autowired
    private final AppServiceUtils appServiceUtils;

    public Stage0point3(AppServiceUtils appServiceUtils) {
        this.appServiceUtils = appServiceUtils;
    }

    public ShelterMessage getAdoptionRules(long shelterId){
        return appServiceUtils.readMessageFromShelterBook(0,3, shelterId);
    }
}
