package pro.sky.botanimalshelter.volunteercrud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.ReportUserCatShelter;
import pro.sky.botanimalshelter.model.ReportUserDogShelter;
import pro.sky.botanimalshelter.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/dog")
    public List<ReportUserDogShelter> viewDogShelterReports() {
        return reportService.getDogShelterReports();
    }

    @PostMapping("/dog")
    public ResponseEntity<ReportUserDogShelter> uploadDogShelterReport(@RequestBody ReportUserDogShelter report) {
        report = reportService.uploadDogShelterReport(report);
        return ResponseEntity.ok(report);
    }

    @PutMapping("/dog")
    public ResponseEntity<ReportUserDogShelter> updateDogShelterReport(
            @RequestBody ReportUserDogShelter reportUserDogShelter) {
        return ResponseEntity.ok(reportService.updateReportDog(reportUserDogShelter));
    }

    @DeleteMapping("/dog/{id}")
    public ResponseEntity<ReportUserDogShelter> deleteReportDog(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.deleteReportUserDogShelter(id));
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<ReportUserDogShelter> viewReportDog(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.findDogReportById(id));
    }

    @GetMapping("/cat")
    public List<ReportUserCatShelter> viewCatShelterReports() {
        return reportService.getCatShelterReports();
    }

    @PostMapping("/cat")
    public ResponseEntity<ReportUserCatShelter> uploadCatShelterReport(@RequestBody ReportUserCatShelter report) {
        report = reportService.uploadCatShelterReport(report);
        return ResponseEntity.ok(report);
    }

    @PutMapping("/cat")
    public ResponseEntity<ReportUserCatShelter> updateCatShelterReport(
            @RequestBody ReportUserCatShelter reportUserCatShelter) {
        return ResponseEntity.ok(reportService.updateReportCat(reportUserCatShelter));
    }

    @DeleteMapping("/cat/{id}")
    public ResponseEntity<ReportUserCatShelter> deleteReportCat(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.deleteReportUserCatShelter(id));
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<ReportUserCatShelter> viewReportCat(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(reportService.findCatReportById(id));
    }

}
