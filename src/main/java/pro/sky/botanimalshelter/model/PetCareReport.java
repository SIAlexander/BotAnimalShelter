package pro.sky.botanimalshelter.model;

public class PetCareReport implements Report {




    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasPhoto() {
        return false;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public long getAuthorId() {
        return 0;
    }

    @Override
    public Profession getAuthorProfession() {
        return null;
    }
}
