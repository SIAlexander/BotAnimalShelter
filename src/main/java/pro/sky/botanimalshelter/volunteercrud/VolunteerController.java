package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.service.VolunteerService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.VolunteerDto;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
@Tag(name = "Контроллер базы данных волонтеров -- Volunteer data base controller",
        description = "Просмотр, создание, редактирование, удаление сущностей из базы данных волонтеров " +
                " View, create, edit, delete volunteer entities from volunteer database")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    @Operation(summary = "просмотр списка волонтеров")
    public List<VolunteerDto> viewAllVolunteers() {
        return volunteerService.viewVolunteers();
    }

    @PostMapping
    @Operation(summary = "Создание сущности волонтера -- Create Volunteer entity")
    public VolunteerDto createVolunteer(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "объект передачи данных сущности волонтера -- data transfer object for Volunteer entity"
            )
            @RequestBody VolunteerDto volunteerDto) {
        return volunteerService.saveVolunteer(volunteerDto);
    }

    @PutMapping
    @Operation(summary = "Редактирование сущности волонтера -- Edit Volunteer entity")
    public VolunteerDto updateVolunteer(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "объект передачи данных сущности волонтера -- data transfer object for Volunteer entity"
            )
            @RequestBody VolunteerDto volunteerDto) {
        return volunteerService.update(volunteerDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление сущности волонтера -- Delete Volunteer entity")
    public VolunteerDto deleteVolunteer(
            @Parameter(name = "id", description = "идентификатор сущности в базе данных -- database identifier")
            @PathVariable(name = "id") Long id) {
        return volunteerService.deleteVolunteer(id);
    }

}
