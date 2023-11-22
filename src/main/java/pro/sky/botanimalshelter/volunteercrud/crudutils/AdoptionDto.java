package pro.sky.botanimalshelter.volunteercrud.crudutils;

/**
 * Объект для передачи данных для усыновления питомца
 */
public class AdoptionDto {
    Long petId;

    Long adopterId;

    public AdoptionDto(Long petId, Long adopterId) {
        this.petId = petId;
        this.adopterId = adopterId;
    }

    public AdoptionDto() {
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Long adopterId) {
        this.adopterId = adopterId;
    }
}
