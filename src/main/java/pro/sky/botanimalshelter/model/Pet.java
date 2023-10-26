package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;
import java.util.Objects;

import static pro.sky.botanimalshelter.model.AdoptionStatus.ON_TRIAL_ADOPTION;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.Specimen.CAT;

//@Entity
public class Pet implements PetInterface {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
//    id, кличка = name, цвет = color, порода = breed

    private long id;

    private Specimen specimen;

    private String name;

    private String color;

    private String breed;

    private Timestamp birthDate;

    private User adopter;

    private AdoptionStatus adoptionStatus;

    private PetShelter shelter;

    public Pet() {
    }


    public boolean giveAdopter(User adopter) {
        if (adopter == null) {
            return false;
        }
        if (adopter.getLovedSpecimen().equals(specimen)){
            this.adopter = adopter;
            this.adoptionStatus = ON_TRIAL_ADOPTION;
            return true;
        } else {return false; }
    }

    public boolean giveShelter(PetShelter shelter) {
        if(isNotNullAndOfRightClass(shelter, CatShelter.class)){
            this.shelter = shelter;
        }
    }

    public AdoptionStatus readAdoptionStatus() {
        return adoptionStatus;
    }

    public void changeAdoptionStatus(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    @Override
    public Specimen readSpecimen() {
        return CAT;
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

    public void setAdopter(User adopter) {
        this.adopter = adopter;
    }

    public CatShelter readShelter() {
        return this.shelter;
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

    public CatShelter getShelter() {
        return shelter;
    }

    public void setShelter(CatShelter shelter) {
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
