package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.model.RecommendationsShelters;
import pro.sky.botanimalshelter.repository.PetShelterRepository;
import pro.sky.botanimalshelter.service.RecommendationsSheltersService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.RecommendationsSheltersDto;

import java.util.List;

@RestController
@Tag(name = "Контроллер для работы с базой данных рекомендаций об усходе за домашними животными " + " - - " +
        "Pet Care Recommendation database controller")
@RequestMapping("/recommendations")
public class RecommendationSheltersController {

    private final RecommendationsSheltersService recommendationsService;
    private final PetShelterRepository shelterRepository;

    public RecommendationSheltersController(RecommendationsSheltersService recommendationsService, PetShelterRepository shelterRepository) {
        this.recommendationsService = recommendationsService;
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("")
    @Operation(summary = "Просмотр списка рекомендаций -- View pet care advice list")
    public List<RecommendationsShelters> viewRecommendations() {
        return recommendationsService.viewRecommendations();
    }

    @PostMapping("")
    @Operation(summary = "Создание рекомендации -- Create pet care advice")
    public RecommendationsShelters newRecommendation(@RequestBody RecommendationsSheltersDto recommendationsSheltersDto) {
        return recommendationsService.save(recommendationsSheltersDto);
    }

}
