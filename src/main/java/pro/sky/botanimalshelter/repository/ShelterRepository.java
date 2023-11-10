package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.PetShelter;

/** storage for PetShelter objects representing shelters for orphan pets*/
@Repository
public interface ShelterRepository extends JpaRepository<PetShelter, Long> {
}
