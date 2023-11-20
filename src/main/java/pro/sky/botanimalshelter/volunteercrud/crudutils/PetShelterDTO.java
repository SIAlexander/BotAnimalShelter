package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.PetShelter;

/**
 * Объект для передачи параметров приюта для животных -- PetShelter data transfer object
 */
public class PetShelterDTO {

    /**
     * Название приюта для животных -- Pet Shelter Name
     */
    private String petShelterName;

    /**
     * Идентификатор приюта для животных в базе данных -- Pet Shelter database Id
     */
    private long petShelterId;

    public PetShelterDTO() {
    }

    public PetShelterDTO(String petShelterName, long petShelterId) {
        this.petShelterName = petShelterName;
        this.petShelterId = petShelterId;
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

    public static PetShelter MakePetShelterFromDto(PetShelterDTO dto) {
        if (dto == null) {
            return null;
        }
        PetShelter petShelter = new PetShelter();
        petShelter.setName(dto.getPetShelterName());
        petShelter.setId(dto.getPetShelterId());
        return petShelter;
    }
}
