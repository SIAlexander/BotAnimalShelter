package pro.sky.botanimalshelter.model;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.Objects;

public class BotLogRecord {
    /**
     * {@code id} is database identifier of record
     */
    private long id;

    /**
     * Date and time of creation of record
     */
    private Timestamp timestamp;
//    private BotLogRecordCategory recordType; // consider it is redundant and should not be so useful

    /**
     * Identifier of Pet Shelter
     */
    private long shelterId;

    /**
     * {@code stageNumber}: stage number by Specification
     */
    private int stageNumber;

    /**
     * {@code pointNumber}: point number as listed by Specification
     */
    private int pointNumber;


    /**
     * {@code positionInProcedure} mean this record of action which is start, interjacent or finish of some procedure
     */
    private PositionInProcedure positionInProcedure;

    /**
     * record of previous action of interjacent or finish action of procedure
     */
    private long previousActionRecordId;

    /**
     * identifier of next action record of start or interjacent action of procedure
     */
    private long nextActionRecordId;

    /**
     * indentifier of user taking part in action
     */
    private long userChatId;

    /**
     *  identifier of pet involved into action
     */
    private long petId;
//
    /**
     * Volunteer taking part in action
     * <br>By the way, if use id only instead of object aggregation,
     * it should not depend on whether volunteer is instance of a dedicated class or User
     */
    private long volunteerChatId; // by the way, if use id only instead of object aggregation, it should not depend on whether volunteer


    private ActionCondition actionCondition;

    private Timestamp scheduledToDo;

    /** procedure result conclusion */
    private Conclusion procedureConclusion;

    public BotLogRecord() {
    }

    public BotLogRecord(long id, Timestamp timestamp, long shelterId, int stageNumber, int pointNumber, PositionInProcedure positionInProcedure, long previousActionRecordId, long nextActionRecordId, long userChatId, long petId, long volunteerChatId, ActionCondition actionCondition, Timestamp scheduledToDo, Conclusion procedureConclusion) {
        this.id = id;
        this.timestamp = timestamp;
        this.shelterId = shelterId;
        this.stageNumber = stageNumber;
        this.pointNumber = pointNumber;
        this.positionInProcedure = positionInProcedure;
        this.previousActionRecordId = previousActionRecordId;
        this.nextActionRecordId = nextActionRecordId;
        this.userChatId = userChatId;
        this.petId = petId;
        this.volunteerChatId = volunteerChatId;
        this.actionCondition = actionCondition;
        this.scheduledToDo = scheduledToDo;
        this.procedureConclusion = procedureConclusion;
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

    public long getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(long userChatId) {
        this.userChatId = userChatId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getVolunteerChatId() {
        return volunteerChatId;
    }

    public void setVolunteerChatId(long volunteerChatId) {
        this.volunteerChatId = volunteerChatId;
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

    public Conclusion getProcedureConclusion() {
        return procedureConclusion;
    }

    public void setProcedureConclusion(Conclusion procedureConclusion) {
        this.procedureConclusion = procedureConclusion;
    }
}
