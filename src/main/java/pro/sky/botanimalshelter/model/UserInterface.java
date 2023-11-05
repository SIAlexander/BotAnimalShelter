package pro.sky.botanimalshelter.model;

public interface UserInterface {
    PetShelter getPetShelter();

    void setPetShelter(PetShelter petShelter);

    @Override
    String toString();

    String getName();

    void setName(String name);

    String getPhone();

    void setPhone(String phone);

    String getEmail();

    void setEmail(String email);

    String getLocation();

    void setLocation(String location);

    PetRelation getPetRelation();

    void setPetRelation(PetRelation petRelation);

    Specimen getLovedSpecimen();

    void setLovedSpecimen(Specimen specimen);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
