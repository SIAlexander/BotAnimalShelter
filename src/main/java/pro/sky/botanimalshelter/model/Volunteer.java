package pro.sky.botanimalshelter.model;

public class Volunteer implements UserInterface{

        private String name;
        private String phone;

        private String email;

        private String location;

        private PetRelation petRelation;

        private Specimen lovedSpecimen;

        private PetShelter petShelter;
    @Override
    public PetShelter getPetShelter() {
        return null;
    }

    @Override
    public void setPetShelter(PetShelter petShelter) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public void setPhone(String phone) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public void setLocation(String location) {

    }

    @Override
    public PetRelation getPetRelation() {
        return null;
    }

    @Override
    public void setPetRelation(PetRelation petRelation) {

    }

    @Override
    public Specimen getLovedSpecimen() {
        return null;
    }

    @Override
    public void setLovedSpecimen(Specimen specimen) {

    }
}
