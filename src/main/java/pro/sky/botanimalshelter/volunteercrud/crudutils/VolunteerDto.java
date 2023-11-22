package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.Volunteer;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.repository.VolunteerRepository;
import pro.sky.botanimalshelter.service.PetShelterService;

/**
 * Объект для передачи данных сущности Volunteer <br> Volunteer entityDTO
 */
public class VolunteerDto {
    private Long id;
    private String name;
    private String phone;
    private Long shelterId;

    private String shelterName;

    public VolunteerDto() {
    }

    public VolunteerDto(Long id, String name, String phone, Long shelterId, String shelterName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.shelterId = shelterId;
        this.shelterName = shelterName;
    }

    public static VolunteerDto dto(Volunteer volunteer) {
        return new VolunteerDto(
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getPhone(),
                volunteer.getShelter().getId(),
                volunteer.getShelter().getName());
    }

    public static Volunteer volunteer(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            return null;
        }
        // Volunteer(String name, String phone, PetShelter shelter)

        return new Volunteer(volunteerDto.name, volunteerDto.phone, new PetShelter());
    }

    public static void setAsDto(Volunteer volunteer, VolunteerDto volunteerDto) {
        volunteer.setName(volunteerDto.name);
        volunteer.setPhone(volunteerDto.phone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }
}
