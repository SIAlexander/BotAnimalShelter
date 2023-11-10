package pro.sky.botanimalshelter.model;

import javax.persistence.*;

/**
 * This model represents volunteer supporting pet shelter
 * it has field fields: <br>{@code id} as primary key in database,
 * <br>{@code name, chatId, phone, email, location} to keep volunteer's name and whereabouts
 * <br>Although Spec don't require to support Telegram chat with volunteer, I consider it is reasonable
 * to have chatId field in Volunteer model, because we develop Telegram bot with loving pets user, also we have to implement
 * some features involving volunteers, so it looks rather reasonable to have a possibility to connect with
 * volunteer by Telegram. <br>Finally, it is very supposable to extend bot functionality with volunteer interface
 * <br><br> {@code petRelation} field is to show volunteer's role in shelter activity
 * <br> <br>{@code lovedSpecimen} shows pet specimen which volunteer intended to care
 * <br> <br>{@code petShelter} means Pet Shelter volunteer assigned to
 */

@Entity
@Table(name = "volunteers")
public class Volunteer implements UserInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chat_id")
    private long chatId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "pet_relation")
    @Enumerated(EnumType.STRING)
    private PetRelation petRelation;

    @Column(name = "loved_specimen")
    @Enumerated(EnumType.STRING)
    private Specimen lovedSpecimen;


    @ManyToOne
    @JoinColumn(name = "petshelter_id")
    private PetShelter petShelter;

    @Override
    public PetShelter getPetShelter() {
        return petShelter;
    }

    @Override
    public void setPetShelter(PetShelter petShelter) {
        this.petShelter = petShelter;
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
        this.lovedSpecimen = specimen;
    }

    public Volunteer() {
    }

    public Volunteer(long id, String name, long chatId, String phone, String email, String location, PetRelation petRelation, Specimen lovedSpecimen, PetShelter petShelter) {
        this.id = id;
        this.name = name;
        this.chatId = chatId;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.petRelation = petRelation;
        this.lovedSpecimen = lovedSpecimen;
        this.petShelter = petShelter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

}
