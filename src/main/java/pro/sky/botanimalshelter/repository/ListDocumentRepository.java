package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ListDocument;

import java.util.List;

@Repository
public interface ListDocumentRepository extends JpaRepository<ListDocument, Long> {
    List<ListDocument> findByShelterName(String name);
}
