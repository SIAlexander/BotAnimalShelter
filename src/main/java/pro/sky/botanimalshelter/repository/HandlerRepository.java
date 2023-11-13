package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.Handler;

import java.util.List;

@Repository
public interface HandlerRepository extends JpaRepository<Handler, Long> {
    List<Handler> findByShelterName(String name);
}
