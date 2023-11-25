package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping()
    String welcomeToPetController() {
        return "Welcome to Pet Controller! ))";
    }

    @GetMapping("/view")
    public List<Pet> viewAllPets() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public Pet viewPet(@PathVariable(name = "id") Long id) {
        return petService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id) {
        return ResponseEntity.ok(petService.deletePet(id));
    }

    @PutMapping("")
    @Operation(summary = "Редактирование данных питомца -- Edit Pet entity data",
            description = "PUT: Редактирование данных питомца." +
                    " В качестве аргумента передается объект с новыми параметрами")
    public ResponseEntity<Pet> editPet(@RequestBody PetDto dto) {
        return ResponseEntity.ok(petService.updatePet(dto));
    }

    @PostMapping("")
    @Operation(summary = "Создание сущности питомца -- Create Pet entity",
            description = "В качестве аргумента передается объект с параметрами")
    public ResponseEntity<Pet> createPet(PetDto petDto) {
        return ResponseEntity.ok(petService.save(petDto));
    }

}
