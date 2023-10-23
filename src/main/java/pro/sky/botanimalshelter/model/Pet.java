package pro.sky.botanimalshelter.model;

public interface Pet { // define only functions related to giving shelter and adoption of a pet


    <T extends PetShelter> void giveShelter(T shelter);

    <T extends PetShelter> T readShelter();

    <R extends HumanGivingCareToPets> R readAdopter();

    <T extends HumanGivingCareToPets> boolean giveAdopter(T adopter);

    AdoptionStatus readAdoptionStatus();

    void changeAdoptionStatus(AdoptionStatus adoptionStatus);

    Specimen readSpecimen();

}
