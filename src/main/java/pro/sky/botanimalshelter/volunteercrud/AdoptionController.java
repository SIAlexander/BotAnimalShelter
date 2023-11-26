package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    /**
     * @param adoptionDto объект передачи параметров назначения усыновителя питомцу, см. {@link AdoptionDto}
     * @return строка с сообщением о результатах выполнения метода
     */
    @Operation(summary = "Назначение усыновителя питомцу-- Assing adopter to pet. ",
            description = "В качестве аргумента передаем объект с новыми параметрами")
    @PostMapping("")
    public String assignPetToUser(@RequestBody AdoptionDto adoptionDto) {
        return adoptionService.adopt(adoptionDto);
    }

}
