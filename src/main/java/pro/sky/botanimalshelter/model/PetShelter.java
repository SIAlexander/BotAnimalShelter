package pro.sky.botanimalshelter.model;

import javax.persistence.*;

/**
 * PetShelter представляет модель приюта для животных
 * Fields: <br> {@code id:} идентификатор в базе данных
 * <br>
 * {@code name:} shelter name,
 * <br> {@code location:} shelter address
 * <br> {@code locationExplanation:} explanation how to get to shelter
 * <br> {@code specimen:} pet specimen allowed to shelter
 * <br> {@code specialistsInfo:} whereabouts of specialists like pet trainers, veterinarians, groomers, etc.
 */
@Entity
@Table(name = "pet_shelter")
public class PetShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specimen")
    @Enumerated(EnumType.STRING)
    private Specimen specimen;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "location")
    private String location;

    @Column(name = "location_explanation")
    private String locationExplanation;

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;

    }


    public String recommendSpecialists() {
        return null;
    }


    public void setSpecialistsInfo(String info) {

    }

    public String getLocationExplanation() {
        return locationExplanation;
    }

    public void setLocationExplanation(String locationExplanation) {
        this.locationExplanation = locationExplanation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
