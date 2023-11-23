package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * <u>Model report user cat shelter.</u>
 * Of the field:
 * <b>Long</b> id,
 * <b>String</b> urlPhoto ,
 * <b>String</b> report,
 * <b>Timestamp</b> dateReport,
 */

@Entity
@Table(name = "report_user_cat_shelter")
public class ReportUserCatShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "report")
    private String report;
    @Column(name = "date_report")
    private Timestamp dateReport;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public ReportUserCatShelter() {
    }

    public ReportUserCatShelter(String urlPhoto, String report, Timestamp dateReport, User user) {
        this.urlPhoto = urlPhoto;
        this.report = report;
        this.dateReport = dateReport;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Timestamp getDateReport() {
        return dateReport;
    }

    public void setDateReport(Timestamp dateReport) {
        this.dateReport = dateReport;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportUserCatShelter that = (ReportUserCatShelter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ReportUserCatShelter{" +
                "id=" + id +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", report='" + report + '\'' +
                ", dateReport=" + dateReport +
                ", user=" + user +
                '}';
    }
}
