package pro.sky.botanimalshelter.model;

public class Dog implements Pet {

    long id;
    String name;

    long adopterId=-1;

    AdoptionStatus adoptionStatus;

    DogShelter dogShelter;
    @Override
    public boolean enterShelter() {

    }

    @Override
    public boolean enterShelter(PetShelter petShelter) {
        if (petShelter == null) {
            return false;
        }
        return  petShelter.getClass().equals(DogShelter.class);
    }

    @Override
    public boolean enterAdoption() {

        return false;
    }

    @Override
    public void approveAdoption() {

    }

    @Override
    public void denyFromAdoption() {

    }

    @Override
    public void leaveShelter() {

    }

    @Override
    public long getAdopterId() {
        return adopterId;
    }

    @Override
    public AdoptionStatus getAdoptionStatus() {
        return adoptionStatus;
    }
}
