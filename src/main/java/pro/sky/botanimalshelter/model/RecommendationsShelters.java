package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * <u>Model recommendations shelters.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> name,
 * <b>String</b> datingRules,
 * <b>String</b> animalTransportation,
 * <b>String</b> homeImprovement,
 * <b>String</b> homeImprovementAdultAnimal,
 * <b>String</b> homeImprovementAnimalWithDisabilities,
 * <b>String</b> listReasonsRefuseAndNotUpAnimal,
 * <b>String</b> recommendationsHandler.
 */

@Entity
@Table(name = "recommendations_shelters")
public class RecommendationsShelters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_shelter")
    private String name;

    @Column(name = "dating_rules")
    private String datingRules; //правила знакомства

    @Column(name = "animal_transportation")
    private String animalTransportation; //рекомендации по транспартировке

    @Column(name = "home_improvement")
    private String homeImprovement; //рекомендации по обустройству дома

    @Column(name = "home_improvement_adult_animal")
    private String homeImprovementAdultAnimal; //рекомендации по обустройству дома для взрослого животного

    @Column(name = "home_improvement_animal_with_disabilities")
    private String homeImprovementAnimalWithDisabilities; //рекомендации по обустройству дома для животного с ограниченными возможностями

    @Column(name = "list_reasons_refuse_and_not_up_animal")
    private String listReasonsRefuseAndNotUpAnimal; //список причин почему могут отказать и недать забрать животное

    @Column(name = "recommendations_handler")
    private String recommendationsHandler; //рекомендации кинолога

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    PetShelter shelter;

    public RecommendationsShelters() {
    }

    public RecommendationsShelters(String name,
                                   String datingRules,
                                   String animalTransportation,
                                   String homeImprovement,
                                   String homeImprovementAdultAnimal,
                                   String homeImprovementAnimalWithDisabilities,
                                   String listReasonsRefuseAndNotUpAnimal,
                                   String recommendationsHandler,
                                   PetShelter shelter) {
        this.name = name;
        this.datingRules = datingRules;
        this.animalTransportation = animalTransportation;
        this.homeImprovement = homeImprovement;
        this.homeImprovementAdultAnimal = homeImprovementAdultAnimal;
        this.homeImprovementAnimalWithDisabilities = homeImprovementAnimalWithDisabilities;
        this.listReasonsRefuseAndNotUpAnimal = listReasonsRefuseAndNotUpAnimal;
        this.recommendationsHandler = recommendationsHandler;
        this.shelter = shelter;
    }

    public RecommendationsShelters(
            Long id,
            String name,
            String datingRules,
            String animalTransportation,
            String homeImprovement,
            String homeImprovementAdultAnimal,
            String homeImprovementAnimalWithDisabilities,
            String listReasonsRefuseAndNotUpAnimal,
            String recommendationsHandler,
            PetShelter shelter) {
        this.id = id;
        this.name = name;
        this.datingRules = datingRules;
        this.animalTransportation = animalTransportation;
        this.homeImprovement = homeImprovement;
        this.homeImprovementAdultAnimal = homeImprovementAdultAnimal;
        this.homeImprovementAnimalWithDisabilities = homeImprovementAnimalWithDisabilities;
        this.listReasonsRefuseAndNotUpAnimal = listReasonsRefuseAndNotUpAnimal;
        this.recommendationsHandler = recommendationsHandler;
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

    public String getDatingRules() {
        return datingRules;
    }

    public void setDatingRules(String datingRules) {
        this.datingRules = datingRules;
    }

    public String getAnimalTransportation() {
        return animalTransportation;
    }

    public void setAnimalTransportation(String animalTransportation) {
        this.animalTransportation = animalTransportation;
    }

    public String getHomeImprovement() {
        return homeImprovement;
    }

    public void setHomeImprovement(String homeImprovement) {
        this.homeImprovement = homeImprovement;
    }

    public String getHomeImprovementAdultAnimal() {
        return homeImprovementAdultAnimal;
    }

    public void setHomeImprovementAdultAnimal(String homeImprovementAdultAnimal) {
        this.homeImprovementAdultAnimal = homeImprovementAdultAnimal;
    }

    public String getHomeImprovementAnimalWithDisabilities() {
        return homeImprovementAnimalWithDisabilities;
    }

    public void setHomeImprovementAnimalWithDisabilities(String homeImprovementAnimalWithDisabilities) {
        this.homeImprovementAnimalWithDisabilities = homeImprovementAnimalWithDisabilities;
    }

    public String getListReasonsRefuseAndNotUpAnimal() {
        return listReasonsRefuseAndNotUpAnimal;
    }

    public void setListReasonsRefuseAndNotUpAnimal(String listReasonsRefuseAndNotUpAnimal) {
        this.listReasonsRefuseAndNotUpAnimal = listReasonsRefuseAndNotUpAnimal;
    }

    public String getRecommendationsHandler() {
        return recommendationsHandler;
    }

    public void setRecommendationsHandler(String recommendationsHandler) {
        this.recommendationsHandler = recommendationsHandler;
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
        RecommendationsShelters that = (RecommendationsShelters) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecommendationsShelters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datingRules='" + datingRules + '\'' +
                ", animalTransportation='" + animalTransportation + '\'' +
                ", homeImprovement='" + homeImprovement + '\'' +
                ", homeImprovementAdultAnimal='" + homeImprovementAdultAnimal + '\'' +
                ", homeImprovementAnimalWithDisabilities='" + homeImprovementAnimalWithDisabilities + '\'' +
                ", listReasonsRefuseAndNotUpAnimal='" + listReasonsRefuseAndNotUpAnimal + '\'' +
                ", recommendationsHandler='" + recommendationsHandler + '\'' +
                ", shelter=" + shelter +
                '}';
    }
}
