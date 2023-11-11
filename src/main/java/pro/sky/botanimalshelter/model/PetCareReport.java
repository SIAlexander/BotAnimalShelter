package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Сущность отчета об условиях содержания и состоянии питомца
 */
@Entity
@Table(name = "pet_care_reports")
public class PetCareReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "path_to_photo")
    private String pathToPhoto;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private Timestamp date;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PetCareReport(long id, User author, Pet pet, String pathToPhoto, String note, Timestamp date) {
        this.id = id;
        this.author = author;
        this.pet = pet;
        this.pathToPhoto = pathToPhoto;
        this.note = note;
        this.date = date;
    }

    public PetCareReport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PetCareReport{" +
                "id=" + id +
                ", author=" + author +
                ", pet=" + pet +
                ", pathToPhoto='" + pathToPhoto + '\'' +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetCareReport that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
