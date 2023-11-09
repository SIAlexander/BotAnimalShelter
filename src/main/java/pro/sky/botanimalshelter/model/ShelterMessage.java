package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Accordingly to Specification bot is to provide a lot of information to user
 * <br>So, ShelterMessage class is a model of messages described by Spec. ShelterMessage also
 * indicates actions to do if required by Spec on the point
 */
@Entity
@Table(name = "shelter_book")
public class ShelterMessage {
    /**
     * {@code id} is database identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shelter_id")
    private long shelterId;

    /**
     * stage number accordingly to Spec
     */
    @Column(name = "stage")
    private int stage;

    /**
     * point order number as it listed in Spec
     */
    @Column(name = "point")
    private int point;

    /**
     * Unique number to specify procedure to perform if it required by Spec
     * At the other hand, stage and messageNumber could exactly point of Spec, so
     * actionId may be redundant.
     * Dear Team, please tell me what you think about this
     */
    @Column(name = "action_id")
    private long actionId;

    /**
     * short title, kind of name of message
     */
    @Column(name = "title")
    private String title;

    /**
     * message to be delivered to user
     */
    @Column(name="text_info")
    private String textInfo;

    public ShelterMessage() {
    }

    public ShelterMessage(Long id, long shelterId, int stage, int point, long actionId, String title, String textInfo) {
        this.id = id;
        this.shelterId = shelterId;
        this.stage = stage;
        this.point = point;
        this.actionId = actionId;
        this.title = title;
        this.textInfo = textInfo;
    }

    public long getShelterId() {
        return shelterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    @Override
    public String toString() {
        return "ShelterMessage{" +
                "shelterId=" + shelterId +
                ", stage=" + stage +
                ", messageNumber=" + point +
                ", actionId=" + actionId +
                ", title='" + title + '\'' +
                ", text='" + textInfo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterMessage that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
