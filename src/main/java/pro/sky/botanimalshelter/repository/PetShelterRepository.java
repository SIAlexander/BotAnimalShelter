package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.PetShelter;

@Repository
public interface PetShelterRepository extends JpaRepository<PetShelter, Long> {
    PetShelter findByName(String name);
}
