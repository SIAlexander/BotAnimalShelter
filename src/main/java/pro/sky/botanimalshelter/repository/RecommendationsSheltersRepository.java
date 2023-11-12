package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.RecommendationsShelters;

import java.util.List;

@Repository
public interface RecommendationsSheltersRepository extends JpaRepository<RecommendationsShelters, Long> {
    RecommendationsShelters findByShelterName(String name);
}
