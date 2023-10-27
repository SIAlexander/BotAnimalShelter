package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

public class PetCareReport {

    User author;

    Pet pet;

    Timestamp dateCreated;

    Timestamp dateReceived;

    public boolean isEmpty() {
        return pet == null;
    }

    public boolean hasPhoto() {
        return false;
    }


    public boolean hasText() {
        return false;
    }

    public Timestamp readReportDate() {
        return null;
    }


    public User readAuthor() {
        return author;
    }


    public boolean appointAuthor(User volunteer) {
        if (volunteer == null) {
            return false;
        }
        author = volunteer;
        return true;
    }


    public Pet readPet() {
        return pet;
    }

    public User readAdopterCandidate() {
        return pet.readAdopter();
    }

}
