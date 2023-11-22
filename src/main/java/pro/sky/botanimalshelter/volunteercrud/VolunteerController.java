package pro.sky.botanimalshelter.volunteercrud;

import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.service.VolunteerService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.VolunteerDto;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public List<VolunteerDto> viewAllVolunteers() {
        return volunteerService.viewVolunteers();
    }

    @PostMapping
    public VolunteerDto createVolunteer(@RequestBody VolunteerDto volunteerDto) {
        return volunteerService.saveVolunteer(volunteerDto);
    }

    @PutMapping
    public VolunteerDto updateVolunteer(@RequestBody VolunteerDto volunteerDto) {
        return volunteerService.update(volunteerDto);
    }

    @DeleteMapping("{id}")
    public VolunteerDto deleteVolunteer(@PathVariable(name = "id") Long id) {
        return volunteerService.deleteVolunteer(id);
    }

}
