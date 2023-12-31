package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.service.HandlerService;
import pro.sky.botanimalshelter.service.PetShelterService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.*;

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
    public List<PetShelterDto> viewPetShetlters() {
        return petShelterService.findAll().stream().
                map(PetShelterDto::toDto).toList();
    }

    @GetMapping("/manage/{id}")
    @Operation(summary = "Управление данными приюта для животных -- Manage pet shelter data",
            description = "GET: просмотр данных приюта с указанным индентификтором -- view data of shelter with specified id")
    public PetShelterDto viewPetShelterData(@Parameter(description = "Идентификатор приюта в базе данных", example = "1") long id) {
        return PetShelterDto.toDto(petShelterService.findShelterById(id));
    }

    @PostMapping("/manage")
    @Operation(summary = "Создание новой сущности приюта для животных-- Creating a new PetShelter entity",
            description = "POST: Создание новой сущности приюта для животных." +
                    "В качестве аргумента передаем объект с параметрами нового приюта")
    public ResponseEntity<PetShelter> establishPetShelter(
            @Parameter(description = "Объект для передачи данных экземпляра PetShelter" +
                    " - - PetShelter data transfer object") @RequestBody PetShelterDto petShelterDTO) {

        PetShelter petShelter = new PetShelter();

        petShelter = petShelterService.save(petShelterDTO);

        return ResponseEntity.ok(petShelter);
    }

    @PutMapping("/manage")
    @Operation(summary = "Редактирование данных приюта для животных -- Editing PetShelter entity",
            description = "PUT: Редактирование данных приюта для животных." +
                    " В качестве аргумента передаем объект с новыми параметрами")
    public ResponseEntity<PetShelter> editPetShelter(
            @Parameter(description = "Объект для передачи данных экземпляра PetShelter" +
                    " - - PetShelter data transfer object") @RequestBody PetShelterDto petShelterDTO) {

        PetShelter petShelter = null;

        if (petShelterService.findShelterById(petShelterDTO.getPetShelterId()) != null) {

            petShelter = petShelterService.save(petShelterDTO);
        }

        return ResponseEntity.ok(petShelter);
    }

    @DeleteMapping("/manage")
    @Operation(summary = "Удаление приюта домашних животных -- Delete Pet Shelter Entity")
    public ResponseEntity<PetShelter> deletePetShelter(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "индентификатор приюта")
            @RequestBody Long id) {
        return ResponseEntity.ok(petShelterService.deleteById(id));
    }

    @GetMapping("/manage/{id}/view-volunteer-list")
    public List<VolunteerDto> viewVolunteers(
            @Parameter(description = "Идентификатор приюта", required = true) @PathVariable(name = "id") Long petShelterId) {
        return petShelterService.getVolunteers(petShelterId);
    }

    @GetMapping("/manage/{id}/view-handler-list")
    public List<HandlerDto> viewHandlers(@PathVariable(name = "id") Long petShelterId) {
        return petShelterService.getHandlers(petShelterId);
    }

    @GetMapping("/manage/{id}/view-list-documents")
    public List<ListDocumentDto> viewListDocuments(@PathVariable(name = "id") Long petShelterId) {
        return petShelterService.getListDocuments(petShelterId);
    }

    @GetMapping("/manage/{id}/view-pets")
    public List<PetDto> viewPets(@PathVariable(name = "id") Long petShelterId) {
        return petShelterService.getPetList(petShelterId);
    }

}
