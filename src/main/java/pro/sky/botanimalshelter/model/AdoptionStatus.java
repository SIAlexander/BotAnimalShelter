package pro.sky.botanimalshelter.model;

/**
 * ORPHAN: pet has no owner, no shelter, no adopter
 * SHELTERED: pet is kept in shelter
 * ON_TRIAL_ADOPTION: pet is on trial adoption
 * ADOPTED: adoption completed, pet is permanently owned by adopted
 */
public enum AdoptionStatus {
    ORPHAN,
    SHELTERED,
    ON_TRIAL_ADOPTION,
    ADOPTED
}
