package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

import static pro.sky.botanimalshelter.model.AdoptionStatus.*;
import static pro.sky.botanimalshelter.model.ModelUtils.isNotNullAndOfRightClass;
import static pro.sky.botanimalshelter.model.ModelUtils.shelterFitsPet;
import static pro.sky.botanimalshelter.model.PetRelation.*;
import static pro.sky.botanimalshelter.model.Specimen.CAT;

public class PetShelter // implements PetShelterInterface
{

    private long id;

    private String name;

    private Specimen specimen;

    private  String location;
    private String locationExplanation;

    /**
     * @param pet means animal to be shelter, nullable
     * @return true if shelter is suitable for pet, i.e. shelter.specimen equals pet.specimen
     */
   public boolean enrollPet(Pet pet) {
        if (shelterFitsPet(this, pet) & ORPHAN.equals(pet.readAdoptionStatus())){
            pet.changeAdoptionStatus(AdoptionStatus.SHELTERED);
            pet.giveShelter(this);
            return true;
        }
        return false;
    }

    /**
     *
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

    }

     /**
     * Dismisses volunteer for any reason
     * @param volunteer User class, nullable
     * @return sets petRelation value of volunteer to PETS_FRIEND
     *      and returns true if volunteer was actually hired by this pet shelter,
     *      i.e. petRelation was VOLUNTEER and petShelter equals this
     */
    public boolean dismissVolunteer(User volunteer) {
            if (ModelUtils.volunteerIsHiredByPetShelter(volunteer, this)) {
                volunteer.setPetRelation(PETS_FRIEND);
                return true; }
            else { return false; }
    }


    public void enrollEmployee(User employee) {
        if (employee == null) {
            return;
        }
        if (!(employee.getPetRelation() == BAD_PETS_FRIEND)) {
            employee.setPetRelation(SHELTER_EMPLOYEE);
        }
    }


    public boolean dismissEmployee(User employee) {
        if (employee == null) {
            return false;
        }
        if ((employee.getPetRelation() == SHELTER_EMPLOYEE)
                &employee.getPetShelter().equals(this)) {
            employee.setPetRelation(PETS_FRIEND);
        }

    }

    @
    public <T extends PetInterface> PetCareReport<T> visitPetAtAdopterHome(T pet, User volunteer) {
        return null;
    }


    public <T extends PetInterface> boolean givePetForAdoptionTrial(T pet, User adopterCandidates) {
            return false;
    }

    @Override
    public <T extends PetInterface> PetCareReport<T> getPetCareReport(T pet, User user) {
        return null;
    }

    @Override
    public void callVolunteerToSupportAdoptionTrial(PetInterface pet, User user) {

    }

    @Override
    public <T extends PetInterface> boolean approveAdoption(T pet) {

        if(!isNotNullAndOfRightClass(pet, Cat.class)) {
            return false;
        }

            pet.changeAdoptionStatus(ADOPTED);
            pet.giveShelter(null);
            pet.readAdopter().setPetRelation(ADOPTER);
            return true;
    }

    @Override
    public <T extends PetInterface> boolean dismissAdoption(T pet) {
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
