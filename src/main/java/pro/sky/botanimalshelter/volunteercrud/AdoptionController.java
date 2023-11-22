package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.service.AdoptionService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.AdoptionDto;

/**
 * Контроллер для передачи питомца усыновителю -- Pet Adoption Controller
 */
@RestController
@RequestMapping("/adoption")
@Tag(name = "Контроллер для передачи питомца усыновителю -- Pet Adoption Controller")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }


    @PostMapping("")
    public String assignPetToUser(@RequestBody AdoptionDto adoptionDto) {
        return adoptionService.adopt(adoptionDto);
    }

}
