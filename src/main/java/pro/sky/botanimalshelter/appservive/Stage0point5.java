package pro.sky.botanimalshelter.appservive;

import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.model.ShelterMessage;
import pro.sky.botanimalshelter.model.User;

/**
 * Этап 0 пункт 5: Вызов волонтера
 */
public class Stage0point5 {

    private final AppServiceUtils appServiceUtils;

    public Stage0point5(AppServiceUtils appServiceUtils) {
        this.appServiceUtils = appServiceUtils;
    }

    /**
     * Сообщаем пользователю  создании вызова волонтера
     */
    public ShelterMessage getCallForVolunteerCreatedInfo(long shelter_id) {
        return appServiceUtils.readMessageFromShelterBook(0, 5, shelter_id);
    }

    /**
     * Сообщаем пользователю  создании вызова волонтера
     */
    public ShelterMessage getCallForVolunteerCreatedInfo(Pet pet) {
        return appServiceUtils.readMessageFromShelterBook(0, 5, pet.getShelter().getId());
    }

    public void createCallForVolunteer(Pet pet, User adopter) {

    }

}
