package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * <u>Model pet shelter.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> name,
 * <b>String</b> location,
 * <b>String</b> phone,
 * <b>String</b> schemesPath,
 * <b>String</b> contactsSecurity,
 * <b>String</b> workSchedule,
 * <b>String</b> storyTheShelter.
 */

/**
 * Сущность приюта домашних животных
 */
@Entity
@Table(name = "shelters")
public class PetShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "phone")
    private String phone;
    @Column(name = "schemes_path")
    private String schemesPath;
    @Column(name = "contacts_security")
    private String contactsSecurity;
    @Column(name = "work_schedule")
    private String workSchedule;

    @Column(name = "story_shelter")
    private String storyTheShelter;

//    @OneToMany(mappedBy = "shelter")
//    List<Volunteer> volunteers;

//    @OneToMany(mappedBy = "shelter")
//    List<Handler> handlers;

//    @OneToMany(mappedBy = "shelter")
//    List<RecommendationsShelters> recommendationsShelters;

//    @OneToMany(mappedBy = "shelter")
//    List<ListDocument> listDocuments;

//    @OneToMany(mappedBy = "shelter")
//    List<Pet> petList;

    public PetShelter() {
    }

    public PetShelter(String name,
                      Long id,
                      String location,
                      String phone,
                      String schemesPath,
                      String contactsSecurity,
                      String workSchedule,
                      String storyTheShelter
            /*        List<Volunteer> volunteers,
                      List<Handler> handlers,
                      List<RecommendationsShelters> recommendationsShelters,
                      List<ListDocument> listDocuments,
                      List<Pet> petList*/) {
        this.name = name;
        this.setId(id);
        this.location = location;
        this.phone = phone;
        this.schemesPath = schemesPath;
        this.contactsSecurity = contactsSecurity;
        this.workSchedule = workSchedule;
        this.storyTheShelter = storyTheShelter;
        /*this.volunteers = volunteers;
        this.handlers = handlers;
        this.recommendationsShelters = recommendationsShelters;
        this.listDocuments = listDocuments;
        this.petList = petList;*/
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchemesPath() {
        return schemesPath;
    }

    public void setSchemesPath(String schemesPath) {
        this.schemesPath = schemesPath;
    }

    public String getContactsSecurity() {
        return contactsSecurity;
    }

    public void setContactsSecurity(String contactsSecurity) {
        this.contactsSecurity = contactsSecurity;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getStoryTheShelter() {
        return storyTheShelter;
    }

    public void setStoryTheShelter(String storyTheShelter) {
        this.storyTheShelter = storyTheShelter;
    }

    /* public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }


    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public List<RecommendationsShelters> getRecommendationsShelters() {
        return recommendationsShelters;
    }

    public void setRecommendationsShelters(List<RecommendationsShelters> recommendationsShelters) {
        this.recommendationsShelters = recommendationsShelters;
    }

    public List<ListDocument> getListDocuments() {
        return listDocuments;
    }

    public void setListDocuments(List<ListDocument> listDocuments) {
        this.listDocuments = listDocuments;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetShelter that = (PetShelter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PetShelter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", schemesPath='" + schemesPath + '\'' +
                ", contactsSecurity='" + contactsSecurity + '\'' +
                ", workSchedule='" + workSchedule + '\'' +
                ", storyTheShelter='" + storyTheShelter + '\'' +
//                ", volunteers=" + volunteers +
//                ", handlers=" + handlers +
//                ", recommendationsShelters=" + recommendationsShelters +
//                ", listDocuments=" + listDocuments +
//                ", petList=" + petList +
                '}';
    }
}
