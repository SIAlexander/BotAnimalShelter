package pro.sky.botanimalshelter.model;

/**
 *     {@code SINGLE } single action in procedure
 *     <br>{@code START, INTERJACENT, FINISH} for action in multi-action procedure,
 *     like checking trial adoption, for instance
 */
public enum PositionInProcedure {
    SINGLE,
    START,
    INTERJACENT,
    FINISH
}
