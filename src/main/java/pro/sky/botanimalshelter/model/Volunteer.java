package pro.sky.botanimalshelter.model;

public class Volunteer implements HumanPerson{

    long id;
    String name;

    String email;

    String phone;

    Profession profession;

    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getPhone() {
        return null;
    }

    public Profession getProfession(){
        return profession;
    }
}
