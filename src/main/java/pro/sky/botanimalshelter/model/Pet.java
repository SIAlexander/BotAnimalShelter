package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * <b>Pet</b> class represents pet animals cared by pet shelter
 */
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "specimen")
    @Enumerated(EnumType.STRING)
    private Specimen specimen;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "breed")
    private String breed;

    @Column(name = "birth_date")
    private Timestamp birthDate;

    @Column(name = "adoption_status")
    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private PetShelter shelter;

    @OneToOne
    @JoinColumn(name = "adopter_id")
    private User adopter;

    public Pet(Long id, Specimen specimen, String name, String color, String breed, Timestamp birthDate, User adopter, AdoptionStatus adoptionStatus, PetShelter shelter) {
        this.id = id;
        this.specimen = specimen;
        this.name = name;
        this.color = color;
        this.breed = breed;
        this.birthDate = birthDate;
        this.adopter = adopter;
        this.adoptionStatus = adoptionStatus;
        this.shelter = shelter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAdopter() {
        return adopter;
    }

    public void setAdopter(User adopter) {
        this.adopter = adopter;
    }

    public Pet() {
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public AdoptionStatus getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public PetShelter getShelter() {
        return shelter;
    }

    public void setShelter(PetShelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet cat)) return false;
        return Objects.equals(getName(), cat.getName()) && Objects.equals(getColor(), cat.getColor()) && Objects.equals(getBreed(), cat.getBreed()) && Objects.equals(getBirthDate(), cat.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                ", adopter=" + //adopter +
                ", adoptionStatus=" + adoptionStatus +
                ", shelter=" + shelter +
                '}';
    }
}
