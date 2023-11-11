package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

public class PetCareReport {

    long id;

    User author;

    Pet pet;

    Timestamp dateCreated;

    Timestamp dateReceived;

    public PetCareReport(long id, User author, Pet pet, Timestamp dateCreated, Timestamp dateReceived) {
        this.id = id;
        this.author = author;
        this.pet = pet;
        this.dateCreated = dateCreated;
        this.dateReceived = dateReceived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetCareReport(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    /*public boolean isEmpty() {
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
    }*/


}
