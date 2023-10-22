package pro.sky.botanimalshelter.model;

import java.sql.Timestamp;

public interface Report {
    boolean isEmpty();

    boolean hasPhoto();

    boolean hasText();

    Timestamp readReportDate();

    User readAuthor();

    boolean appointAuthor(User volunteer);

    <T extends Pet> T readPet();

    <T extends Pet> void appointPet(T pet);

    User readAdopterCandidate();

}
