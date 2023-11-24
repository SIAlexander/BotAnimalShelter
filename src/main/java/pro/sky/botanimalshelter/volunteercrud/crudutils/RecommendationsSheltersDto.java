package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.PetShelter;

/**
 * Объект передачи данных рекомендаций по уходу за питомцами (класс RecommendationsSheltersDto) -- RecommendationsShelters data transfer object
 */
public class RecommendationsSheltersDto {

    private Long id;
    private String name,
            datingRules,
            animalTransportation,
            homeImprovement,
            homeImprovementAdultAnimal,
            homeImprovementAnimalWithDisabilities,
            listReasonsRefuseAndNotUpAnimal,
            recommendationsHandler;
    private Long shelterId;

    public RecommendationsSheltersDto(Long id, String name, String datingRules,
                                      String animalTransportation, String homeImprovement,
                                      String homeImprovementAdultAnimal,
                                      String homeImprovementAnimalWithDisabilities,
                                      String listReasonsRefuseAndNotUpAnimal,
                                      String recommendationsHandler, Long shelterId) {
        this.id = id;
        this.name = name;
        this.datingRules = datingRules;
        this.animalTransportation = animalTransportation;
        this.homeImprovement = homeImprovement;
        this.homeImprovementAdultAnimal = homeImprovementAdultAnimal;
        this.homeImprovementAnimalWithDisabilities = homeImprovementAnimalWithDisabilities;
        this.listReasonsRefuseAndNotUpAnimal = listReasonsRefuseAndNotUpAnimal;
        this.recommendationsHandler = recommendationsHandler;
        this.shelterId = shelterId;
    }

    public RecommendationsSheltersDto() {
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

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    @Override
    public String toString() {
        return "RecommendationsSheltersDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datingRules='" + datingRules + '\'' +
                ", animalTransportation='" + animalTransportation + '\'' +
                ", homeImprovement='" + homeImprovement + '\'' +
                ", homeImprovementAdultAnimal='" + homeImprovementAdultAnimal + '\'' +
                ", homeImprovementAnimalWithDisabilities='" + homeImprovementAnimalWithDisabilities + '\'' +
                ", listReasonsRefuseAndNotUpAnimal='" + listReasonsRefuseAndNotUpAnimal + '\'' +
                ", recommendationsHandler='" + recommendationsHandler + '\'' +
                ", shelterId=" + shelterId +
                '}';
    }
}
