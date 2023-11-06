package pro.sky.botanimalshelter.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static pro.sky.botanimalshelter.model.AdoptionStatus.ON_TRIAL_ADOPTION;

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
    private Specimen specimen;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "breed")
    private String breed;

    @Column(name = "birth_date")
    private Timestamp birthDate;


    /**
     * adopter assigned to oet
     */

    @ManyToMany
    @JoinColumn(name = "adopter_id")
    private User adopter;

    @Column(name = "adoption_status")
    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    /**
     * shelter keeping pet until adoption
     */

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private PetShelter shelter;


    public Pet() {
    }

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

    /**
     * giveAdopter method assigns pet to adopter candidate
     *
     * @param adopterCandidate User adopter candidate, Nullable
     * @return true if adopter candidate successfully assigned to pet
     */
    public boolean giveAdopter(User adopterCandidate) {
        if (adopterCandidate == null) {
            return false;
        }
        if (adopterCandidate.getLovedSpecimen().equals(specimen)) {
            this.adopter = adopterCandidate;
            this.adoptionStatus = ON_TRIAL_ADOPTION;
            return true;
        } else {
            return false;
        }
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    /**
     * @param shelter nullable
     * @return true upon successful assignment pet to shelter
     */
    public boolean giveShelter(PetShelter shelter) {
        if (shelter != null) {
            final boolean equals = specimen.equals(shelter.getSpecimen());
            if (equals) {
                this.shelter = shelter;
                return true;
            }
        }
        return false;
    }

    public PetShelter readShelter() {
        return this.shelter;
    }

    public AdoptionStatus readAdoptionStatus() {
        return adoptionStatus;
    }

    /**
     * @param adoptionStatus AdoptionStatus value to be set as status of pet adoption
     *                       <p>Be aware changeAdoptionStatus changes status of adoption value immediately,
     *                       so potentially it could violate business logic /p>
     */
    public void changeAdoptionStatus(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public Specimen readSpecimen() {
        return specimen;
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

    public User readAdopter() {
        return adopter;
    }

    /**
     * Be careful using setter because potentially it could violate business logic
     *
     * @param adopter
     */
    public void setAdopter(User adopter) {
        this.adopter = adopter;
    }

    public User getAdopter() {
        return adopter;
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
        return Objects.hash(getName(), getColor(), getBreed(), getBirthDate());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                ", adopter=" + adopter +
                ", adoptionStatus=" + adoptionStatus +
                ", shelter=" + shelter +
                '}';
    }
}
