package pro.sky.botanimalshelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.botanimalshelter.model.Volunteer;

public interface ReportVolunteerRepository extends JpaRepository<Volunteer, Long> {
}
