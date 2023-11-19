package pro.sky.botanimalshelter.model;

public interface Report {
    boolean isEmpty();

    boolean hasPhoto();

    boolean hasText();

    String getDate();

    long getAuthorId();

   // Profession getAuthorProfession();
}
