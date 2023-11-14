package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * <u>Model user.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>Long</b> chatId,
 * <b>String</b> name,
 * <b>String</b> phone,
 * <b>String</b> email,
 * <b>String</b> location.
 */

@Entity
@Table(name ="users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_chat")
    private Long chatId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "user")
    List<Pet> pets;

    public User() {
    }

    public User(Long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }

    public User(Long chatId, String name, String phone, String email, String location, List<Pet> pets) {
        this.chatId = chatId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", pets=" + pets +
                '}';
    }
}
