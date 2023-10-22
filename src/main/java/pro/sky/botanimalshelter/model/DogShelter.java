package pro.sky.botanimalshelter.model;

import static pro.sky.botanimalshelter.model.AdoptionStatus.*;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.PetRelation.ADOPTER;
import static pro.sky.botanimalshelter.model.PetRelation.ADOPTER_CANDIDATE;
import static pro.sky.botanimalshelter.model.Specimen.DOG;

public class DogShelter implements PetShelter {

    long id;

    String name;

    String location;

    String locationExplanation;

    String specialistsInfo;

    String petCareAdvice;

    @Override
    public void enrollPet(Pet pet) {

    }

    @Override
    public void enrollVolunteer(User volunteer) {
        if (volunteer == null){ return;}
        volunteer.setPetRelation(PetRelation.VOLUNTEER);
    }

    @Override
    public void dismissVolunteer(User volunteer) {

    }

    @Override
    public <T extends Pet> boolean givePetForAdoptionTrial(T pet, User adopterCandidate) {
        if (pet == null || adopterCandidate == null) {
            return false;
        }

        if (!pet.readAdoptionStatus().equals(SHELTERED)
        ) {
            return false;
        }


        boolean b = pet.giveAdopter(adopterCandidate);
        if (b) {
            pet.changeAdoptionStatus(ON_TRIAL_ADOPTION);
            adopterCandidate.setPetRelation(ADOPTER_CANDIDATE);
            return true;}
        return false;
    }

    @Override
    public <T extends Pet> PetCareReport<T> getPetCareReport(T pet, User volunteer) {
        if (!isNotNullAndOfRightClass(pet, Dog.class)) {return null;}
        return new PetCareReport<>();
    }

    @Override
    public <T extends Pet> void callVolunteerToSupportAdoptionTrial(T pet, User volunteer) {

    }

    @Override
    public <T extends Pet> PetCareReport<T> visitPetAtAdopterHome(T pet, User volunteer) {
        return null;
    }


    @Override
    public <T extends Pet> boolean approveAdoption(T pet) {

        if (isNotNullAndOfRightClass(pet, Dog.class)
                & pet.readAdoptionStatus().equals(ON_TRIAL_ADOPTION)) {
            pet.readAdopter().setPetRelation(PetRelation.ADOPTER);
            pet.changeAdoptionStatus(ADOPTED);
            pet.giveShelter(null);
            return true;
        }

        return false;
    }

    @Override
    public <T extends Pet> boolean dismissAdoption(T pet) {
        if(!isNotNullAndOfRightClass(pet, Dog.class)
        || !(pet.readAdoptionStatus().equals(ON_TRIAL_ADOPTION))){
            return false;
        }
        pet.changeAdoptionStatus(ADOPTED);
        pet.readAdopter().setPetRelation(ADOPTER);
        return true;

    }

    @Override
    public Specimen getSpecimen() {
        return DOG;
    }

    @Override
    public void setSpecimen(Specimen specimen) {
    }

    @Override
    public String getPetCareAdvice() {
        return petCareAdvice;
    }

    @Override
    public void setPetCareAdvice(String advice) {
            petCareAdvice = advice;
    }

    @Override
    public String recommendSpecialists() {
        return specialistsInfo;
    }

    @Override
    public void setSpecialistsInfo(String info) {
        specialistsInfo = info;
    }

    @Override
    public String getLocationExplanation() {
        return locationExplanation;
    }

    @Override
    public void setLocationExplanation(String explanation) {
        locationExplanation = explanation;
    }
}
