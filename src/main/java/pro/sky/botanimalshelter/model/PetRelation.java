package pro.sky.botanimalshelter.model;

/**
 * <p/>Roles as followed GUEST, PETS_FRIEND, VOLUNTEER, ADOPTER_CANDIDATE, ADOPTER, BAD_PETS_FRIEND are to
 * determine user roles explicitly required by Specification</p>
 * <p></p>
 * <p>GUEST: user just started with bot</p>
 * <p></p>
 * <p>PETS_FRIEND: registered with bot. From this status user could become either volunteer, or adopter candidate
 * </p>
 * <p>ADOPTER_CANDIDATE: started trial adoption</p>
 * <p></p>
 * ADOPTER: user achieves this status upon successful completion of trial adoption
 * <p></p>
 * BAD_PETS_FRIEND: person failed to be real pets friend because of bad results of trial adoption or
 * demonstrated bad approach to pets by some other way
 * <p></p>
 * <p>Specification does not tell whether pet care specialists and enthusiasts should use this bot,
 * but as they meant by Specification, so VOLUNTEER, PET_TRAINER, SHELTER_EMPLOYEE, VETERINARIAN role values created </p>
 * <p></p>
 * <p>VOLUNTEER: volunteer supporting particular pet shelter. Supposed could retire to PETS_FRIEND</p>
 * <p></p>
 * </p>PET_TRAINER depending on lovedSpecimen value could mean cynologist (if DOG), or felinologist(if CAT), etc.
 * <p></p><p>SHELTER_EMPLOYEE person hired by shelter </p>
 * <p></p><p>VETERINARIAN pet doctor</p>
 */
public enum PetRelation {
    GUEST,
    PETS_FRIEND,
    ADOPTER_CANDIDATE,
    ADOPTER,
    BAD_PETS_FRIEND,
    VOLUNTEER,
    SHELTER_EMPLOYEE,
    PET_TRAINER,
    VETERINARIAN
}
