package pro.sky.botanimalshelter.model;

public interface Pet {
    boolean enterShelter();

    boolean enterShelter(PetShelter petShelter);

    boolean enterAdoption();

    void approveAdoption();

    void denyFromAdoption();

    void leaveShelter();

    long getAdopterId();

    AdoptionStatus getAdoptionStatus();
}
