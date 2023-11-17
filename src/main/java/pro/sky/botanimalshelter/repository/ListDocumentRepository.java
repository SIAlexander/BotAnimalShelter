package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.botanimalshelter.model.ListDocument;

import java.util.List;
/**
 * Repository for working with the {@link ListDocument} entity in the database
 */
@Repository
public interface ListDocumentRepository extends JpaRepository<ListDocument, Long> {
    /**
     * The method of finding a shelter in the database
     * @param name
     * @return {@link List}
     */
    List<ListDocument> findByShelterName(String name);
}
