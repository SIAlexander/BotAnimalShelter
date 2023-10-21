package pro.sky.botanimalshelter.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.botanimalshelter.model.HumanPerson;

public interface HumanPersonRepository extends JpaRepository<HumanPerson, Long> {
}
