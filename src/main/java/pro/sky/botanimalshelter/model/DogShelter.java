package pro.sky.botanimalshelter.model;

import static pro.sky.botanimalshelter.model.AdoptionStatus.*;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.PetRelation.*;
import static pro.sky.botanimalshelter.model.Specimen.DOG;

public class DogShelter implements PetShelter {

    private long id;

    private String name;

    private String location;

    private String locationExplanation;

    private String specialistsInfo;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLocationExplanation(String locationExplanation) {
        this.locationExplanation = locationExplanation;
    }

    public String getSpecialistsInfo() {
        return specialistsInfo;
    }

    private String petCareAdvice;

    final private Specimen specimen = DOG;

    @Override
    public void enrollPet(Pet pet) {

    }

    @Override
    public void enrollVolunteer(User volunteer) {
        if (volunteer == null) {
            return;
        }
        volunteer.setPetRelation(PetRelation.VOLUNTEER);
    }

    @Override
    public void dismissVolunteer(User volunteer) {
        if (volunteer == null) {
            return;
        }
        if (volunteer.getPetRelation() == VOLUNTEER) {
            volunteer.setPetRelation(PETS_FRIEND);
        }
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

        if (employee.getPetRelation() == SHELTER_EMPLOYEE) {
            employee.setPetRelation(PETS_FRIEND);
        }
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
            return true;
        }
        return false;
    }

    @Override
    public <T extends Pet> PetCareReport<T> getPetCareReport(T pet, User volunteer) {
        if (!isNotNullAndOfRightClass(pet, Dog.class)) {
            return null;
        }
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
        if (!isNotNullAndOfRightClass(pet, Dog.class)
                || !(pet.readAdoptionStatus().equals(ON_TRIAL_ADOPTION))) {
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
    public String readLocationExplanation() {
        return locationExplanation;
    }


    public String getLocationExplanation() {
        return locationExplanation;
    }

    @Override
    public void writeLocationExplanation(String explanation) {
        locationExplanation = explanation;
    }
}
