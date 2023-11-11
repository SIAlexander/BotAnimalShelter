package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;


/**
 * User class represents different roles of users: from guest to adopter.
 * Potentially, volunteer and employee role also could be supported by User class
 */
@Entity
@Table(name = "users")
public class User implements UserInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;


    @Enumerated(EnumType.STRING)
    @Column(name = "petRelation")
    private PetRelation petRelation;

    @Column(name = "loved_specimen")
    @Enumerated(EnumType.STRING)
    private Specimen lovedSpecimen;

    @ManyToOne
    @JoinColumn(name = "pet_shelter")
    private PetShelter petShelter;

    @Override
    public PetShelter getPetShelter() {
        return petShelter;
    }

    @Override
    public void setPetShelter(PetShelter petShelter) {
        this.petShelter = petShelter;
    }

    /**
     * {@code chatId} user chat identifier
     */
    @Column(name = "id_chat")
    private long chatId;

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    long getId() {
        return id;
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

    public User(long id, String name, String phone, String email, String location,
                PetRelation petRelation, Specimen lovedSpecimen, PetShelter petShelter, long chatId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.petRelation = petRelation;
        this.lovedSpecimen = lovedSpecimen;
        this.petShelter = petShelter;
        this.chatId = chatId;
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
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
