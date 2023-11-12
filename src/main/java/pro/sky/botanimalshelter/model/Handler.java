package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "handlers")
public class Handler {

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

    public Handler() {
    }

    public Handler(String name, String phone, PetShelter shelter) {
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
        Handler handler = (Handler) o;
        return Objects.equals(id, handler.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Handler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", shelter=" + shelter +
                '}';
    }
}
