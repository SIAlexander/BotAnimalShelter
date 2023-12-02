package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.service.PetService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.PetDto;

import java.util.List;

@RestController
@RequestMapping(name = "/pet")
@Tag(name = "Контроллер для работы с базой данных домашних животных " + " - - " +
        "Pet database controller")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/view")
    @Operation(summary = "Просмотр списка всех питомцев -- View all pets")
    public List<Pet> viewAllPets() {
        return petService.findAll();
    }

    @GetMapping()
    @Operation(summary = "Приветствие пользователя -- Welcome user")
    String welcomeToPetController() {
        return "Welcome to Pet Controller! ))";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Просмотр данных питомца с указанным идентификатором -- View details of pet with id as provided")
    public Pet viewPet(
            @Parameter(name = "id", description = "Pet entity database identifier")
            @PathVariable(name = "id") Long id) {
        return petService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление питомца с указанным идентификатором -- Delete pet with id as provided")
    public ResponseEntity<Pet> deletePet(
            @Parameter(name = "id", description = "Pet entity database identifier")
            @PathVariable Long id) {
        return ResponseEntity.ok(petService.deletePet(id));
    }

    @PutMapping("")
    @Operation(summary = "Редактирование данных питомца -- Edit Pet entity data",
            description = "PUT: Редактирование данных питомца." +
                    " В качестве аргумента передается объект с новыми параметрами")
    public ResponseEntity<Pet> editPet(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description =
                    "Data transfer object with up-to-date parameters")
            @RequestBody PetDto dto) {
        return ResponseEntity.ok(petService.updatePet(dto));
    }

    @PostMapping("")
    @Operation(summary = "Создание сущности питомца -- Create Pet entity",
            description = "В качестве аргумента передается объект с параметрами")
    public ResponseEntity<Pet> createPet(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description =
                            "Data transfer object with new pet parameters"
            )
            @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.save(petDto));
    }

}
