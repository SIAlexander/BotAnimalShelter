package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.PetShelter;

/**
 * Объект для передачи параметров приюта для животных -- PetShelter data transfer object
 */
public class PetShelterDto {

    /**
     * Название приюта для животных -- Pet Shelter Name
     */
    private String petShelterName;

    /**
     * Идентификатор приюта для животных в базе данных -- Pet Shelter database Id
     */
    private long petShelterId;

    /**
     * Адрес приюта для животных
     */
    private String petShelterLocation;

    private String petShelterPhone;

    private String petShelterSchemesPath;

    private String petShelterWorkSchedule;

    private String petShelterStory;

    private String petShelterContactsSecurity;

    public String getPetShelterSchemesPath() {
        return petShelterSchemesPath;
    }

    public void setPetShelterSchemesPath(String petShelterSchemesPath) {
        this.petShelterSchemesPath = petShelterSchemesPath;
    }

    public String getPetShelterWorkSchedule() {
        return petShelterWorkSchedule;
    }

    public void setPetShelterWorkSchedule(String petShelterWorkSchedule) {
        this.petShelterWorkSchedule = petShelterWorkSchedule;
    }

    public String getPetShelterStory() {
        return petShelterStory;
    }

    public void setPetShelterStory(String petShelterStory) {
        this.petShelterStory = petShelterStory;
    }

    public PetShelterDto(String petShelterName, long petShelterId, String petShelterLocation, String petShelterPhone, String petShelterSchemesPath, String petShelterWorkSchedule, String petShelterStory, String petShelterContactsSecurity) {
        this.petShelterName = petShelterName;
        this.petShelterId = petShelterId;
        this.petShelterLocation = petShelterLocation;
        this.petShelterPhone = petShelterPhone;
        this.petShelterSchemesPath = petShelterSchemesPath;
        this.petShelterWorkSchedule = petShelterWorkSchedule;
        this.petShelterStory = petShelterStory;
        this.petShelterContactsSecurity = petShelterContactsSecurity;
    }

    public String getPetShelterLocation() {
        return petShelterLocation;
    }

    public void setPetShelterLocation(String petShelterLocation) {
        this.petShelterLocation = petShelterLocation;
    }



    /**
     * Контактные данные охраны
     */
//    private String petShelterSecurityContacts;

    public PetShelterDto() {
    }

    public String getPetShelterName() {
        return petShelterName;
    }

    public void setPetShelterName(String petShelterName) {
        this.petShelterName = petShelterName;
    }

    public long getPetShelterId() {
        return petShelterId;
    }

    public void setPetShelterId(long petShelterId) {
        this.petShelterId = petShelterId;
    }

    public String getPetShelterPhone() {
        return petShelterPhone;
    }

    public void setPetShelterPhone(String petShelterPhone) {
        this.petShelterPhone = petShelterPhone;
    }

    public String getPetShelterContactsSecurity() {
        return petShelterContactsSecurity;
    }

    public void setPetShelterContactsSecurity(String petShelterContactsSecurity) {
        this.petShelterContactsSecurity = petShelterContactsSecurity;
    }

    /**
     * @param dto экземпляр класса PetShelterDto для передачи параметров сущности приюта животных PetShelter<br>Nullable
     * @return экземпляр класса PetShelter или null, если параметр пустой
     */
    public static PetShelter toPetShelter(PetShelterDto dto) {

        if (dto == null) {
            return null;
        }
        return new PetShelter(
                dto.petShelterName,
                dto.petShelterId,
                dto.petShelterLocation,
                dto.petShelterPhone,
                dto.petShelterSchemesPath,
                dto.petShelterContactsSecurity,
                dto.getPetShelterWorkSchedule(),
                dto.petShelterStory);
    }

    public static PetShelterDto toDto(PetShelter petShelter) {
        if (petShelter == null) return null;
        return new PetShelterDto(petShelter.getName(), petShelter.getId(),
                petShelter.getLocation(),
                petShelter.getPhone(), petShelter.getSchemesPath(),
                petShelter.getWorkSchedule(), petShelter.getStoryTheShelter(),
                petShelter.getContactsSecurity());
    }

}
