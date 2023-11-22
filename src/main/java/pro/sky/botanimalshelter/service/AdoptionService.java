package pro.sky.botanimalshelter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.model.User;
import pro.sky.botanimalshelter.volunteercrud.crudutils.AdoptionDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdoptionService {

    private final UserService userService;

    private final PetService petService;


    public AdoptionService(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }

    public String adopt(@RequestBody AdoptionDto adoptionDto) {
        if (adoptionDto == null) {
            return "Передан пустой объект с параметрами усыновления";
        }
        String string = "Питомец: ";
        Long petId = adoptionDto.getPetId();
        Long adopterId = adoptionDto.getAdopterId();

        Pet pet = petService.findById(petId);
        if (pet == null) {
            return "Питомец с указанным идентификатором отсутствует. Id= " + petId;
        }

        User user = userService.findById(adopterId);
        if (user == null) {
            return "Пользователь с указанным идентификатором отсутствует. Id= " + adopterId;
        }

        List<Pet> petList = user.getPets();
        if (petList == null) {
            petList = new ArrayList<>();
            petList.add(pet);
            user.setPets(petList);
        } else {
            user.getPets().add(pet);
        }

        userService.saveUser(user);

        string = string + pet + " передан на усыновление пользователю " +
                user;

        return string;
    }
}
