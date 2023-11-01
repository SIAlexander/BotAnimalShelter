package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_chat")
    private Long idChat;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @Column(name = "pet_relation")
    private String petRelation;
    @Column(name = "loved_specimen")
    private String lovedSpecimen;

    public Users() {
    }

    public Users(Long idChat, String name) {
        this.idChat = idChat;
        this.name = name;
    }

    public Users(Long idChat, String name, String phone, String email, String location, String petRelation, String lovedSpecimen) {
        this.idChat = idChat;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.petRelation = petRelation;
        this.lovedSpecimen = lovedSpecimen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPetRelation() {
        return petRelation;
    }

    public void setPetRelation(String petRelation) {
        this.petRelation = petRelation;
    }

    public String getLovedSpecimen() {
        return lovedSpecimen;
    }

    public void setLovedSpecimen(String lovedSpecimen) {
        this.lovedSpecimen = lovedSpecimen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", idChat=" + idChat +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", petRelation='" + petRelation + '\'' +
                ", lovedSpecimen='" + lovedSpecimen + '\'' +
                '}';
    }
}
