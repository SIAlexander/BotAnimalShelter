package pro.sky.botanimalshelter.model;

public class ModelUtils {

    public static <T> boolean isNotNullAndOfRightClass(T object, Class<?> rightClass) {
        if (object == null) {
            return false;
        }
        return object.getClass().equals(rightClass);
    }

}
