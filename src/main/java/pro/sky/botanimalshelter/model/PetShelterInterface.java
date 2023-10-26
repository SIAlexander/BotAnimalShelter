package pro.sky.botanimalshelter.model;

public interface PetShelterInterface {

    <T extends PetInterface> void enrollPet(T pet);

    void enrollVolunteer(User volunteer);

    void dismissVolunteer(User volunteer);

    void enrollEmployee(User employee);

    void dismissEmployee(User employee);

    <T extends PetInterface> boolean givePetForAdoptionTrial(T pet, User adopterCandidate);

    <T extends PetInterface> PetCareReport<T> getPetCareReport(T pet, User volunteer);

    <T extends PetInterface> void callVolunteerToSupportAdoptionTrial(T pet, User volunteer);

    <T extends PetInterface> PetCareReport<T> visitPetAtAdopterHome(T pet, User volunteer);

    <T extends PetInterface> boolean approveAdoption(T pet);

    <T extends PetInterface> boolean dismissAdoption(T pet);

    Specimen getSpecimen();

    void setSpecimen(Specimen specimen);

    String getPetCareAdvice();

    void setPetCareAdvice(String advice);

    String recommendSpecialists(); // recommend specialists for additional pet care
                                    // like cynologists and felinologist

    void setSpecialistsInfo(String info); // set info regarding pet specialists

    String readLocationExplanation(); // Tell how to get to shelter location

    void writeLocationExplanation(String explanation); // Fix how to get to shelter location explanation

}
