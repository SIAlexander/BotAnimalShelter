package pro.sky.botanimalshelter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat implements Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    long adopterId = -1;

    AdoptionStatus adoptionStatus;

    @Override
    public boolean enterShelter() {
        return false;
    }

    @Override
    public boolean enterShelter(PetShelter petShelter) {

        return false;
    }

    @Override
    public boolean enterAdoption() {
        return false;
    }

    @Override
    public void approveAdoption() {

    }

    @Override
    public void denyFromAdoption() {

    }

    @Override
    public void leaveShelter() {

    }

    @Override
    public long getAdopterId() {
        return adopterId;
    }

    @Override
    public AdoptionStatus getAdoptionStatus() {
        return adoptionStatus;
    }
}
