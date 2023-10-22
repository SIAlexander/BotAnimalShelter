package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

public class PetCareReport<P extends Pet> implements Report {

    User author;

    P pet;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasPhoto() {
        return false;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public Timestamp readReportDate() {
        return null;
    }

    @Override
    public User readAuthor() {
        return author;
    }

    @Override
    public boolean appointAuthor(User volunteer) {
        if(volunteer == null) { return false; }
        author = volunteer;
        return true;
    }

    public <T extends Pet> void appointPet(T pet) {
        this.pet = (P) pet;
    }

    @Override
    public <T extends Pet> T readPet() {
        return (T) pet;
    }


    @Override
    public User readAdopterCandidate() {
        return pet.readAdopter();
    }

}
