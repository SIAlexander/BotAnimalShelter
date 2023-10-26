package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;
import java.util.Objects;

import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.Specimen.DOG;

public class Dog implements PetInterface {
//    id, кличка = name, цвет = color, порода = breed

    private long id;

    private String name;

    private String color;

    private String breed;

    private Timestamp birthDate;

    private User adopter;

    private AdoptionStatus adoptionStatus;

    private DogShelter dogShelter;


    @Override
    public <T extends PetShelterInterface> void giveShelter(T shelter) {

        if (!isNotNullAndOfRightClass(shelter, DogShelter.class)){
            this.dogShelter = (DogShelter) shelter;
        }

    }

    @Override
    public <T extends HumanGivingCareToPets> boolean giveAdopter(T adopter) {
        if (isNotNullAndOfRightClass(adopter, User.class)
        &adopter.getLovedSpecimen().equals(DOG)){
            this.adopter = (User) adopter;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public AdoptionStatus readAdoptionStatus() {
        return adoptionStatus;
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

    public DogShelter getDogShelter() {
        return dogShelter;
    }

    @Override
    public void changeAdoptionStatus(AdoptionStatus adoptionStatus) {

    }

    @Override
    public Specimen readSpecimen() {
        return DOG;
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                ", adopter=" + adopter +
                ", adoptionStatus=" + adoptionStatus +
                ", shelter=" + dogShelter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        return getId() == dog.getId() && Objects.equals(getName(), dog.getName()) && Objects.equals(getColor(), dog.getColor()) && Objects.equals(getBreed(), dog.getBreed()) && Objects.equals(getBirthDate(), dog.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getColor(), getBreed(), getBirthDate());
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

    public <T extends HumanGivingCareToPets> T  readAdopter() {
        return (T) adopter;
    }

    public void setAdopter(User adopter) {
        this.adopter = adopter;
    }

    public <T extends PetShelterInterface> T readShelter() {
        return (T) dogShelter;
    }

    public void setDogShelter(DogShelter shelter) {
        this.dogShelter = shelter;
    }
}
