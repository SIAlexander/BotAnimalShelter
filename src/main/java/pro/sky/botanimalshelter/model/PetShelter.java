package pro.sky.botanimalshelter.model;

import static pro.sky.botanimalshelter.model.AdoptionStatus.*;
import static pro.sky.botanimalshelter.model.ModelUtils.shelterFitsPet;
import static pro.sky.botanimalshelter.model.PetRelation.*;

public class PetShelter {

    private long id;

    private String name;

    private Specimen specimen;

    private String location;
    private String locationExplanation;

    /**
     * @param pet means animal to be shelter, nullable
     * @return true if shelter is suitable for pet, i.e. shelter.specimen equals pet.specimen
     */
    public boolean enrollPet(Pet pet) {
        if (shelterFitsPet(this, pet) & ORPHAN.equals(pet.readAdoptionStatus())) {
            pet.changeAdoptionStatus(AdoptionStatus.SHELTERED);
            pet.giveShelter(this);
            return true;
        }
        return false;
    }

    /**
     * @param volunteer - User class. Means a person that is going to become
     *                  volunteer supporting this shelter
     * @return true if volunteer loves pets of same specimen as shelter specialized and sets
     * volunteer petRelation status to VOLUNTEER
     */
    public boolean enrollVolunteer(User volunteer) {

        if (volunteer == null) {
            return false;
        }
        if (volunteer.getLovedSpecimen().equals(this.specimen)
                & PETS_FRIEND.equals(volunteer.getPetRelation())) {
            volunteer.setPetRelation(VOLUNTEER);
            return true;
        }
        return false;

    }

    /**
     * Dismisses volunteer for any reason
     *
     * @param volunteer User class, nullable
     * @return sets petRelation value of volunteer to PETS_FRIEND
     * and returns true if volunteer was actually hired by this pet shelter,
     * i.e. petRelation was VOLUNTEER and petShelter equals this
     */
    public boolean dismissVolunteer(User volunteer) {
        if (ModelUtils.volunteerIsHiredByPetShelter(volunteer, this)) {
            volunteer.setPetRelation(PETS_FRIEND);
            return true;
        } else {
            return false;
        }
    }

    public boolean enrollEmployee(User employee) {
        if (employee == null) {
            return false;
        }
        if (BAD_PETS_FRIEND.equals(employee.getPetRelation())) {
            return false;
        }
            employee.setPetRelation(SHELTER_EMPLOYEE);
            employee.setPetShelter(this);
            return true;
    }

    public boolean dismissEmployee(User employee) {
        if (employee == null) {
            return false;
        }
        if ((employee.getPetRelation() == SHELTER_EMPLOYEE)
                & employee.getPetShelter().equals(this)) {
            employee.setPetRelation(PETS_FRIEND);
            return true;
        }
        return false;
    }

    public PetCareReport visitPetAtAdopterHome(Pet pet, User volunteer) {
        return new PetCareReport();
    }


    public boolean givePetForAdoptionTrial(Pet pet, User adopterCandidates) {

        return false;
    }

    public PetCareReport getPetCareReport(Pet pet, User volunteer) {
        return null;
    }

    public boolean callVolunteerToSupportAdoptionTrial(Pet pet, User volunteer) {
        return false;
    }


    public boolean approveAdoption(Pet pet) {
        if (pet == null) {
            return false;
        }
        if (pet.getAdopter() == null) {
            return false;
        }

        if (ON_TRIAL_ADOPTION.equals(pet.readAdoptionStatus())) {
            pet.setAdoptionStatus(ADOPTED);
            pet.getAdopter().setPetRelation(ADOPTER);
            return true;
        }
        return false;
    }

    public boolean dismissAdoption(Pet pet) {

        if (pet == null) {
            return false;
        }

        if (pet.getAdopter() == null
                || !ON_TRIAL_ADOPTION.equals(pet.getAdoptionStatus())
                || !ADOPTER_CANDIDATE.equals(pet.getAdopter().getPetRelation())) {
            return false;
        }

        pet.changeAdoptionStatus(SHELTERED);
        pet.readAdopter().setPetRelation(BAD_PETS_FRIEND);
        return true;
    }


    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {

    }

    public String getPetCareAdvice() {
        return null;
    }


    public void setPetCareAdvice(String advice) {

    }


    public String recommendSpecialists() {
        return null;
    }


    public void setSpecialistsInfo(String info) {

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

}
