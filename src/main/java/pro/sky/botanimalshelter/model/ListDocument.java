package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * <u>Model document list.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> document
 */

@Entity
@Table(name = "list_documents")
public class ListDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document")
    private String document;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    PetShelter shelter;

    public ListDocument() {
    }

    public ListDocument(String document, PetShelter shelter) {
        this.document = document;
        this.shelter = shelter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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
        ListDocument document = (ListDocument) o;
        return Objects.equals(id, document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ListDocument{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", shelter=" + shelter +
                '}';
    }
}
