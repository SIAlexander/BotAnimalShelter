package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.PetShelter;

/** База данных приютов - сущностей PetShelter*/
@Repository
public interface ShelterRepository extends JpaRepository<PetShelter, Long> {
}
