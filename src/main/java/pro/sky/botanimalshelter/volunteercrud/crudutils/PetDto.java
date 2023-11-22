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

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public PetDto(Long petId, String petName, String petColor, Timestamp petBirthDate) {
        this.petId = petId;
        this.petName = petName;
        this.petColor = petColor;
        this.petBirthDate = petBirthDate;
    }

    public PetDto() {
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

    public static Pet makePetFromDto(PetDto petDto) {
        if (petDto == null) {
            return null;
        }
        Pet pet = new Pet();
        pet.setId(petDto.petId);
        pet.setName(petDto.petName);
        pet.setColor(petDto.petColor);
        pet.setBirthDate(petDto.petBirthDate);
        return pet;
    }

}
