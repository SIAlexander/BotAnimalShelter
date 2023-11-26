package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * <u>Model pet.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> name,
 * <b>String</b> color,
 * <b>Timestamp birthDate</b>
 */

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "birth_date")
    private Timestamp birthDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    PetShelter shelter;


    public Pet(){

    }

    public Pet(String dog1, String brown, Date date) {

    public Pet() {

    }

    public Pet(String name, String color, Timestamp birthDate, User user, PetShelter shelter) {
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
        this.user = user;
        this.shelter = shelter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PetShelter getShelter() {
        return shelter;
    }

    public void setShelter(PetShelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", birthDate=" + birthDate +
                ", user=" + user +
                ", shelter=" + shelter +
                '}';
    }
}
