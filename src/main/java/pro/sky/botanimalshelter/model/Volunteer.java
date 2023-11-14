package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * <u>Model volunteer.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> name,
 * <b>String</b> phone,
 */

@Entity
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    PetShelter shelter;

    public Volunteer() {
    }

    public Volunteer(String name, String phone, PetShelter shelter) {
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        Volunteer volunteer = (Volunteer) o;
        return Objects.equals(id, volunteer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", shelter=" + shelter +
                '}';
    }
}
