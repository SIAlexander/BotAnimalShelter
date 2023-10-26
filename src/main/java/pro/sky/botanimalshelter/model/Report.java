package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

public interface Report {
    boolean isEmpty();

    boolean hasPhoto();

    boolean hasText();

    Timestamp readReportDate();

    User readAuthor();

    boolean appointAuthor(User volunteer);

    <T extends PetInterface> T readPet();

    <T extends PetInterface> void appointPet(T pet);

    User readAdopterCandidate();

}
