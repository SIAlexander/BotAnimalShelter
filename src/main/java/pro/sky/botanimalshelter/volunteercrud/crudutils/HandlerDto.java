package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.Handler;

/**
 * Объект передачи данных сущности кинолога (Handler) -- Handler entity DTO
 */
public class HandlerDto {
    private Long id;
    private String name;
    private String phone;
    private Long shelterId;
    private String shelterName;

    public HandlerDto() {
    }

    public HandlerDto(Long id, String name, String phone, Long shelterId, String shelterName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.shelterId = shelterId;
        this.shelterName = shelterName;
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


