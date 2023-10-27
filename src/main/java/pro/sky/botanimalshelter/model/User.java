package pro.sky.botanimalshelter.model;

import java.util.Objects;

public class User implements UserInterface {
    private String name;
    private String phone;

    private String email;

    private String location;

    private PetRelation petRelation;

    private Specimen lovedSpecimen;

    private PetShelter petShelter;

    @Override
    public PetShelter getPetShelter() {
        return petShelter;
    }

    @Override
    public void setPetShelter(PetShelter petShelter) {
        this.petShelter = petShelter;
    }

    private long chatId;

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", lovedSpecimen=" + lovedSpecimen +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    public User(String name, String phone, String email, String location, Specimen lovedSpecimen) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.lovedSpecimen = lovedSpecimen;
    }

    public User() {
    }

    @Override
    public PetRelation getPetRelation() {
        return petRelation;
    }

    @Override
    public void setPetRelation(PetRelation petRelation) {
        this.petRelation = petRelation;

    }


    @Override
    public Specimen getLovedSpecimen() {
        return lovedSpecimen;
    }

    @Override
    public void setLovedSpecimen(Specimen specimen) {
        lovedSpecimen = specimen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getName(),
                user.getName()) && Objects.equals(getPhone(),
                user.getPhone()) && Objects.equals(getEmail(),
                user.getEmail()) && Objects.equals(getLocation(),
                user.getLocation()) && getLovedSpecimen() == user.getLovedSpecimen();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getEmail(), getLocation(), getLovedSpecimen());
    }
}
