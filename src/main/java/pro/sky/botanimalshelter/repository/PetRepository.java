package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
