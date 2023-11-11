package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.botanimalshelter.model.PetCareReport;

/**
 * Репозиторий отчетов об условиях содержания и состоянии здоровья питомцев на временном усыновлении
 */
public interface PetCareReportRepository extends JpaRepository<PetCareReport, Long> {
}
