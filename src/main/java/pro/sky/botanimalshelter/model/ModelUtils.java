package pro.sky.botanimalshelter.model;

import static pro.sky.botanimalshelter.model.PetRelation.VOLUNTEER;

public class ModelUtils {

    public static User getNobody(){
      return new User("Nobody", "", "", "", null);
    }


    public static <T> boolean isNotNullAndOfRightClass(T object, Class<?> rightClass) {
        if (object == null) {
            return false;
        }
        return object.getClass().equals(rightClass);
    }

    public static boolean shelterFitsPet(PetShelter shelter, Pet pet) {
        if (shelter == null || pet == null) {
            return false;
        }
        return shelter.getSpecimen().equals(pet.readSpecimen());
    }

    public static boolean volunteerIsHiredByPetShelter(User volunteer, PetShelter petShelter){
        if (volunteer == null || petShelter == null){
            return false;
        }
        return VOLUNTEER.equals(volunteer.getPetRelation()) & petShelter.equals(volunteer.getPetShelter());
    }

}
