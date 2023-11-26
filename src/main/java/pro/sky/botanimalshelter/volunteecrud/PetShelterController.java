package pro.sky.botanimalshelter.volunteecrud;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.botanimalshelter.service.PetShelterService;

@RestController
@Tag(name = "Контроллер для работы с базой данных приютов для домашних животных " + " - - " +
        "Pet Shelter database controller")
@RequestMapping("/petshelter")
public class PetShelterController {

    private final PetShelterService petShelterService;

    public PetShelterController(PetShelterService petShelterService) {
        this.petShelterService = petShelterService;
    }

    @GetMapping("")
    public String welcome() {
        return "Welcome to Pet Shelter database Controller!";
    }
}
