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

    public PetShelterDto() {
    }

    public PetShelterDto(String petShelterName, long petShelterId) {
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

    /**
     * @param dto экземпляр класса PetShelterDto для передачи параметров сущности приюта животных PetShelter<br>Nullable
     * @return экземпляр класса PetShelter или null, если параметр пустой
     */
    public static PetShelter MakePetShelterFromDto(PetShelterDto dto) {
        if (dto == null) {
            return null;
        }
        PetShelter petShelter = new PetShelter();
        petShelter.setName(dto.getPetShelterName());
        petShelter.setId(dto.getPetShelterId());
        return petShelter;
    }

    public static PetShelterDto makeDtoFromPetShelter(PetShelter petShelter) {
        if (petShelter == null) return null;
        return new PetShelterDto(petShelter.getName(), petShelter.getId());
    }

    /**
     * @param petShelterDto Nullable
     * @return строку с параметрами PetShelterDto или сообщением о том,
     * что в качестве аргкмента был передан пустой объект
     */
    public static String toString(PetShelterDto petShelterDto) {
        if (petShelterDto == null) {
            return "Пустой объект petShelterDto";
        }
        return "Приют животных<br>" +
                "ID: " + petShelterDto.petShelterId + "<br>" +
                "Name: " + petShelterDto.petShelterName;
    }
}
