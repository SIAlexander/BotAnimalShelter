package pro.sky.botanimalshelter.model;

import javax.persistence.*;

import static pro.sky.botanimalshelter.model.AdoptionStatus.*;
import static pro.sky.botanimalshelter.model.ModelUtils.shelterFitsPet;
import static pro.sky.botanimalshelter.model.PetRelation.*;

/**
 * PetShelter class represents pet shelter in our project
 * Fields: <br> {@code id:} identifier, auto generated by database
 * <br>
 * {@code name:} shelter name,
 * <br> {@code location:} shelter address
 * <br> {@code locationExplanation:} explanation how to get to shelter
 * <br> {@code specimen:} pet specimen allowed to shelter
 * <br> {@code specialistsInfo:} whereabouts of specialists like pet trainers, veterinarians, groomers, etc.
 */
@Entity
@Table(name = "pet_shelter")
public class PetShelter {

    /*CREATE table pet_shelter
            (
                    id                    SERIAL PRIMARY KEY,
                    name                  TEXT,
                    location              TEXT,
                    location_explanation TEXT,
                    specialists_info      TEXT
            );*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specimen")
    @Enumerated(EnumType.STRING)
    private Specimen specimen;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "location")
    private String location;

    @Column(name = "location_explanation")
    private String locationExplanation;

    /**
     * @param pet means animal to be sheltered, nullable
     * @return true if shelter is suitable for pet, i.e. shelter.specimen equals pet.specimen
     */
    public boolean enrollPet(Pet pet) {
        if (shelterFitsPet(this, pet) & ORPHAN.equals(pet.getAdoptionStatus())) {
            pet.setAdoptionStatus(AdoptionStatus.SHELTERED);
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

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;

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
