package pro.sky.botanimalshelter.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * {@code BotlogRecord} class represents bot log record <br> Log should be useful to keep history of users activity
 * and events, ans also to schedule actions
 */
@Entity
@Table(name = "botlog")
public class BotLogRecord {
    /**
     * {@code id} is database identifier of record
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Date and time of creation of record
     */
    @Column(name = "date_created")
    private Timestamp timestamp;
//    private BotLogRecordCategory recordType; // consider it is redundant and should not be so useful

    /**
     * Identifier of Pet Shelter
     */
    @Column(name = "shelter_id")
    private long shelterId;

    /**
     * {@code stageNumber}: stage number by Specification
     */
    @Column(name = "stage_number")
    private int stageNumber;

    /**
     * {@code pointNumber}: point number as listed by Specification
     */
    @Column(name = "point_number")
    private int pointNumber;


    /**
     * {@code positionInProcedure} mean this record of action which is start, interjacent or finish of some procedure
     */
    @Column(name = "position_in_procedure")
    @Enumerated(EnumType.STRING)
    private PositionInProcedure positionInProcedure;

    /**
     * record of previous action of interjacent or finish action of procedure
     */
    @Column(name = "previous_action_record_id")
    private long previousActionRecordId;

    /**
     * identifier of next action record of start or interjacent action of procedure
     */
    @Column(name = "next_action_record_id")
    private long nextActionRecordId;

    /**
     * indentifier of user taking part in action
     */
    @Column(name = "user_id")
    private long userId;

    /**
     * identifier of pet involved into action
     */
    @Column(name = "pet_id")
    private long petId;

    /**
     * Volunteer taking part in action
     * <br>By the way, if use id only instead of object aggregation,
     * it should not depend on whether volunteer is instance of a dedicated class or User
     */
    @Column(name = "volunteer_id")
    private long volunteerId; // by the way, if use id only instead of object aggregation, it should not depend on whether volunteer

    /**
     * TO_DO, IN_PROGRESS, DONE
     */
    @Column(name = "action_condition")
    @Enumerated(EnumType.STRING)
    private ActionCondition actionCondition;

    /**
     * some actions should be scheduled, so scheduledToDo means scheduled time for this
     */
    @Column(name = "scheduled_to_do")
    private Timestamp scheduledToDo;

    /**
     * result of action or procedure<br>
     * {@code ONE, FAILED, PET_IS_GIVEN_ON_TRIAL_ADOPTION, ADOPTION_APPROVED}
     * <br>Please let me know values you really need
     */
    @Column(name = "conclusion")
    @Enumerated(EnumType.STRING)
    private Conclusion conclusion;

    /**
     * some note may be written here
     */
    @Column(name = "note")
    private String note;

    public BotLogRecord() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BotLogRecord(long id, Timestamp timestamp, long shelterId, int stageNumber, int pointNumber,
                        PositionInProcedure positionInProcedure, long previousActionRecordId,
                        long nextActionRecordId, long userId, long petId, long volunteerId,
                        ActionCondition actionCondition, Timestamp scheduledToDo,
                        Conclusion conclusion, String note) {
        this.id = id;
        this.timestamp = timestamp;
        this.shelterId = shelterId;
        this.stageNumber = stageNumber;
        this.pointNumber = pointNumber;
        this.positionInProcedure = positionInProcedure;
        this.previousActionRecordId = previousActionRecordId;
        this.nextActionRecordId = nextActionRecordId;
        this.userId = userId;
        this.petId = petId;
        this.volunteerId = volunteerId;
        this.actionCondition = actionCondition;
        this.scheduledToDo = scheduledToDo;
        this.conclusion = conclusion;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BotLogRecord that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public int getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(int pointNumber) {
        this.pointNumber = pointNumber;
    }

    public PositionInProcedure getPositionInProcedure() {
        return positionInProcedure;
    }

    public void setPositionInProcedure(PositionInProcedure positionInProcedure) {
        this.positionInProcedure = positionInProcedure;
    }

    public long getPreviousActionRecordId() {
        return previousActionRecordId;
    }

    public void setPreviousActionRecordId(long previousActionRecordId) {
        this.previousActionRecordId = previousActionRecordId;
    }

    public long getNextActionRecordId() {
        return nextActionRecordId;
    }

    public void setNextActionRecordId(long nextActionRecordId) {
        this.nextActionRecordId = nextActionRecordId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public ActionCondition getActionCondition() {
        return actionCondition;
    }

    public void setActionCondition(ActionCondition actionCondition) {
        this.actionCondition = actionCondition;
    }

    public Timestamp getScheduledToDo() {
        return scheduledToDo;
    }

    public void setScheduledToDo(Timestamp scheduledToDo) {
        this.scheduledToDo = scheduledToDo;
    }

    public Conclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }
}
