package pro.sky.botanimalshelter.model;

import static pro.sky.botanimalshelter.model.AdoptionStatus.ADOPTED;
import static pro.sky.botanimalshelter.model.AdoptionStatus.SHELTERED;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.PetRelation.BAD_PETS_FRIEND;
import static pro.sky.botanimalshelter.model.Specimen.CAT;

public class CatShelter implements PetShelter {

    long id;

    Specimen specimen = CAT;

    String name;


    @Override
    public <T extends Pet> void enrollPet(T pet) {
        if (isNotNullAndOfRightClass(pet, Cat.class)){
            pet.changeAdoptionStatus(AdoptionStatus.SHELTERED);
            pet.giveShelter(this);
        };
    }

    @Override
    public void enrollVolunteer(User volunteer) {

    }

    @Override
    public void dismissVolunteer(User volunteer) {

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
    public String getLocationExplanation() {
        return null;
    }

    @Override
    public void setLocationExplanation(String explanation) {

    }
}
