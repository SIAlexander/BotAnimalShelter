package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.Pet;

import java.sql.Timestamp;

/**
 * Объект передачи данных питомца
 */
public class PetDto {

    private Long petId;

    private String petName;

    private String petColor;

    private Timestamp petBirthDate;

    private Long shelterId;
    private Long userId;

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public PetDto(Long petId, String petName, String petColor, Timestamp petBirthDate,
                  Long shelterId, Long userId) {
        this.petId = petId;
        this.petName = petName;
        this.petColor = petColor;
        this.petBirthDate = petBirthDate;
        this.shelterId = shelterId;
        this.userId = userId;
    }

    public PetDto() {
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Timestamp getPetBirthDate() {
        return petBirthDate;
    }

    public void setPetBirthDate(Timestamp petBirthDate) {
        this.petBirthDate = petBirthDate;
    }


    /**
     * Converts Pet to data transfer object
     *
     * @param pet nullable
     * @return Data transfer object or null if null argument provided
     */
    public static PetDto toDto(Pet pet) {
        if (pet == null) {
            return null;
        }
        Long shelterId = -1L,
                userId = -1L;
        if (pet.getShelter() != null) {
            shelterId = pet.getShelter().getId();
        }
        if (pet.getUser() != null) {
            userId = pet.getUser().getId();
        }
        return new PetDto(pet.getId(), pet.getName(),
                pet.getColor(), pet.getBirthDate(),
                shelterId, userId);
    }

}
