package pro.sky.botanimalshelter.model;

public interface PetShelter {

    <T extends Pet> void enrollPet(T pet);

    void enrollVolunteer(User volunteer);

    void dismissVolunteer(User volunteer);

    void enrollEmployee(User employee);

    void dismissEmployee(User employee);

    <T extends Pet> boolean givePetForAdoptionTrial(T pet, User adopterCandidate);

    <T extends Pet> PetCareReport<T> getPetCareReport(T pet, User volunteer);

    <T extends Pet> void callVolunteerToSupportAdoptionTrial(T pet, User volunteer);

    <T extends Pet> PetCareReport<T> visitPetAtAdopterHome(T pet, User volunteer);

    <T extends Pet> boolean approveAdoption(T pet);

    <T extends Pet> boolean dismissAdoption(T pet);

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
