package pro.sky.botanimalshelter.model;

import java.util.Objects;

/**
 * Accordingly to Specification bot is to provide a lot of information to user
 * <br>So, ShelterMessage class is a model of messages described by Spec and
 * indicate actions to do if necessary
 */
public class ShelterMessage {
    /**
     * record identifier in database
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * {@code id} is database identifier
     */
    private Long id;

    private long shelterId;

    /**
     * stage number accordingly to Spec
     */
    private int stage;

    /**
     * message order number as it listed in Spec
     */
    private int messageNumber;

    /**
     * Unique number to specify procedure to perform if it required by Spec
     * At the other hand, stage and messageNumber could exactly point of Spec, so
     * actionId may be redundant.
     * Dear Team, please tell me what you think about this
     */
    private long actionId;

    /**
     * short title, kind of name of message
     */
    private String title;

    /**
     * message to be delivered to user
     */
    private String text;

    public ShelterMessage() {
    }

    public ShelterMessage(Long id, long shelterId, int stage, int messageNumber, long actionId, String title, String text) {
        this.id = id;
        this.shelterId = shelterId;
        this.stage = stage;
        this.messageNumber = messageNumber;
        this.actionId = actionId;
        this.title = title;
        this.text = text;
    }

    public long getShelterId() {
        return shelterId;
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

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ShelterMessage{" +
                "shelterId=" + shelterId +
                ", stage=" + stage +
                ", messageNumber=" + messageNumber +
                ", actionId=" + actionId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
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
