package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.service.PetShelterService;

import java.util.List;

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
    @Operation(summary = "Стартовая страница контроллера -- Controller home page",
            description = "Приветствие пользователя -- Greet the User")
    public String welcome() {
        return "<h1>Welcome to Pet Shelter database Controller!" +
                "-- Добро пожаловать в контроллер базы приютов домашних животных</h1>";
    }

    @GetMapping("/view")
    @Operation(summary = "Просмотр списка приютов для животных -- View pet shelter list",
            description = "")
    public List<PetShelter> viewPetShetlters() {
        return petShelterService.findAll();
    }

    @GetMapping("/manage/{id}")
    @Operation(summary = "Управление данными приюта для животных -- Manage pet shelter data",
            description = "GET: view data of shelter with specified id")

    public String viewPetShelterData(long id) {
        return petShelterService.findShelterById(id).toString();
    }


}
