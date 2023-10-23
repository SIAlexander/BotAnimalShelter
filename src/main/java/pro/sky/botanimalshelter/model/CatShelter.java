package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

import static pro.sky.botanimalshelter.model.AdoptionStatus.ADOPTED;
import static pro.sky.botanimalshelter.model.AdoptionStatus.SHELTERED;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.PetRelation.*;
import static pro.sky.botanimalshelter.model.Specimen.CAT;

public class CatShelter implements PetShelter {

    private long id;

    private String color;

    private String breed;

    private String name;

    private Timestamp birthDate;

    private final Specimen specimen = CAT;

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

    private String locationExplanation;


    @Override
    public <T extends Pet> void enrollPet(T pet) {
        if (isNotNullAndOfRightClass(pet, Cat.class)){
            pet.changeAdoptionStatus(AdoptionStatus.SHELTERED);
            pet.giveShelter(this);
        };
    }

    @Override
    public void enrollVolunteer(User volunteer) {

        if (volunteer == null) {
            return;
        }
        if (volunteer.getPetRelation() == PETS_FRIEND) {
            volunteer.setPetRelation(VOLUNTEER);
        }

    }

    @Override
    public void dismissVolunteer(User volunteer) {

    }

    @Override
    public void enrollEmployee(User employee) {
        if (employee == null) {
            return;
        }
        if (!(employee.getPetRelation() == BAD_PETS_FRIEND)) {
            employee.setPetRelation(SHELTER_EMPLOYEE);
        }
    }

    @Override
    public void dismissEmployee(User employee) {
        if (employee == null) {
            return;
        }
        if ((employee.getPetRelation() == SHELTER_EMPLOYEE)) {
            employee.setPetRelation(PETS_FRIEND);
        }

    }

    @Override
    public <T extends Pet> PetCareReport<T> visitPetAtAdopterHome(T pet, User volunteer) {
        return null;
    }

    @Override
    public <T extends Pet> boolean givePetForAdoptionTrial(T pet, User adopterCandidates) {
            return false;
    }

    @Override
    public <T extends Pet> PetCareReport<T> getPetCareReport(T pet, User user) {
        return null;
    }

    @Override
    public void callVolunteerToSupportAdoptionTrial(Pet pet, User user) {

    }

    @Override
    public <T extends Pet> boolean approveAdoption(T pet) {

        if(!isNotNullAndOfRightClass(pet, Cat.class)) {
            return false;
        }

            pet.changeAdoptionStatus(ADOPTED);
            pet.giveShelter(null);
            pet.readAdopter().setPetRelation(PetRelation.ADOPTER);
            return true;
    }

    @Override
    public <T extends Pet> boolean dismissAdoption(T pet) {
        if (!isNotNullAndOfRightClass(pet, Cat.class)) {
            return false;
        }
        pet.changeAdoptionStatus(SHELTERED);
        pet.readAdopter().setPetRelation(BAD_PETS_FRIEND);
        return true;
    }

    @Override
    public Specimen getSpecimen() {
        return specimen;
    }

    @Override
    public void setSpecimen(Specimen specimen) {

    }

    @Override
    public String getPetCareAdvice() {
        return null;
    }

    @Override
    public void setPetCareAdvice(String advice) {

    }

    @Override
    public String recommendSpecialists() {
        return null;
    }

    @Override
    public void setSpecialistsInfo(String info) {

    }

    @Override
    public String readLocationExplanation() {
        return locationExplanation;
    }

    public String getLocationExplanation() {
        return locationExplanation;
    }

    public void setLocationExplanation(String locationExplanation) {
        this.locationExplanation = locationExplanation;
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

    @Override
    public void writeLocationExplanation(String explanation) {
        locationExplanation = explanation;
    }
}
