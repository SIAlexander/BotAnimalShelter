package pro.sky.botanimalshelter.volunteercrud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.Pet;
import pro.sky.botanimalshelter.service.PetService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.PetDto;

import java.util.List;

@RestController
@RequestMapping(name = "/pet")
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

    @PostMapping("/new")
    public ResponseEntity<Pet> createPet(@RequestBody PetDto petDto) {
        Pet pet = PetDto.makePetFromDto(petDto);
        pet = petService.save(pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id) {
        return ResponseEntity.ok(petService.deletePet(id));
    }

}
