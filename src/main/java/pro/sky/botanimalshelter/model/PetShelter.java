package pro.sky.botanimalshelter.model;

public interface PetShelter {

    void enrollPet(Pet pet);

    void enrollVolunteer(Volunteer volunteer);

    void givePetForAdoptionTrial(Pet pet, Adapter adapter);

    PetCareReport getPetCareReport(Pet pet, Adapter adapter);

    void callVolunteerToSupportAdoptionTrial(Pet pet, Adapter adapter);

    PetCareReport visitPetAtAdopterHome(Pet pet, Adapter adapter);

    void approveAdoption(Pet pet, Adapter adapter);

    void dismissAdoption(Pet pet, Adapter adapter);

}
