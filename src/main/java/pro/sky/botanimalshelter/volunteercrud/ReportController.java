package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@Tag(name = "Контроллер для работы с базой данных отчетов кандидатов в усыновители домашних животных" + " - - " +
        "Adopter candidate report database controller")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/dog")
    @Operation(summary = "Просмотр отчетов усыновителей собак")
    public List<ReportUserDogShelter> viewDogShelterReports() {
        return reportService.getDogShelterReports();
    }

    @PostMapping("/dog")
    @Operation(summary = "Сохранение нового отчета")
    public ResponseEntity<ReportUserDogShelter> uploadDogShelterReport(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "сущность отчета кандидата в усыновители"
            )
            @RequestBody ReportUserDogShelter report) {
        report = reportService.uploadDogShelterReport(report);
        return ResponseEntity.ok(report);
    }

    @PutMapping("/dog")
    @Operation(summary = "Update report")
    public ResponseEntity<ReportUserDogShelter> updateDogShelterReport(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "up-to-date dog adopter report"
            )
            @RequestBody ReportUserDogShelter reportUserDogShelter) {
        return ResponseEntity.ok(reportService.updateReportDog(reportUserDogShelter));
    }

    @DeleteMapping("/dog/{id}")
    @Operation(summary = "Удаление отчета кандидата в усыновители собаки -- Delete dog adopter candidate report")
    public ResponseEntity<ReportUserDogShelter> deleteReportDog(
            @Parameter(name = "id", description = "dog adopter candidate report")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.deleteReportUserDogShelter(id));
    }

    @GetMapping("/dog/{id}")
    @Operation(summary = "View dog adopter candidate report")
    public ResponseEntity<ReportUserDogShelter> viewReportDog(
            @Parameter(name = "id", description = "dog adopter candidate report")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.findDogReportById(id));
    }

    @GetMapping("/cat")
    @Operation(summary = "View cat adopter candidate reports")
    public List<ReportUserCatShelter> viewCatShelterReports() {
        return reportService.getCatShelterReports();
    }

    @PostMapping("/cat")
    @Operation(summary = "Upload cat adopter candidate report")
    public ResponseEntity<ReportUserCatShelter> uploadCatShelterReport(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "cat adopter candidate report entity"
            )
            @RequestBody ReportUserCatShelter report) {
        report = reportService.uploadCatShelterReport(report);
        return ResponseEntity.ok(report);
    }

    @PutMapping("/cat")
    @Operation(summary = "Обновление отчета кандидата в усыновители кошки -- Update cat adopter candidate report")
    public ResponseEntity<ReportUserCatShelter> updateCatShelterReport(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "up-to-date cat adopter candidate report"
            )
            @RequestBody ReportUserCatShelter reportUserCatShelter) {
        return ResponseEntity.ok(reportService.updateReportCat(reportUserCatShelter));
    }

    @DeleteMapping("/cat/{id}")
    @Operation(summary = "Удаление отчета кандидата в усыновители кошки -- Delete cat adopter candidate report")
    public ResponseEntity<ReportUserCatShelter> deleteReportCat(
            @Parameter(name = "id", description = "идентификатор отчета -- report database id")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.deleteReportUserCatShelter(id));
    }

    @GetMapping("/cat/{id}")
    @Operation(summary = "Просмотр отчета кандидата в усыновители кошки -- View cat adopter candidate report")
    public ResponseEntity<ReportUserCatShelter> viewReportCat(
            @Parameter(name = "id", description = "идентификатор отчета в базе данных -- report database identifier")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.findCatReportById(id));
    }

}
