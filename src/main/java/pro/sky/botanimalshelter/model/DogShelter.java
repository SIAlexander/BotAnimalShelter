package pro.sky.botanimalshelter.model;

public class DogShelter implements PetShelter{
    @Override
    public void enrollPet(Pet pet) {

    }

    @Override
    public void enrollVolunteer(Volunteer volunteer) {

    }

    @Override
    public void givePetForAdoptionTrial(Pet pet, Adapter adapter) {

    }

    @Override
    public PetCareReport getPetCareReport(Pet pet, Adapter adapter) {
        return null;
    }

    @Override
    public void callVolunteerToSupportAdoptionTrial(Pet pet, Adapter adapter) {

    }

    @Override
    public PetCareReport visitPetAtAdopterHome(Pet pet, Adapter adapter) {
        return null;
    }

    @Override
    public void approveAdoption(Pet pet, Adapter adapter) {

    }

    @Override
    public void dismissAdoption(Pet pet, Adapter adapter) {

    }
}
