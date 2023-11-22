package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.service.HandlerService;

import java.util.List;

@RestController
@RequestMapping("/handler")
@Tag(name = "Контроллер для работы с БД кинологов -- Dog Trainer DB CRUD Controller")
public class HandlerController {
    private final HandlerService handlerService;

    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    /**
     * Welcome User!
     */
    @Operation(summary = "Стартовая страница контроллера -- Controller home page", description = "Приветствие пользователя -- Greet the User")
    @GetMapping("")
    public String welcome() {
        return "Добро пожаловать в контроллер кинолога! -- Welcome to Handler Controller!";
    }

    /**
     * Сохраняем кинолога -- Save dog trainer
     */
    @Operation(summary = "Сохранение кинолога -- Saving dog trainer",
            description = "Сохраняет экземпляр класса handler c указанными именем и телефоном," +
                    " и приютом в соответствии с указанным индентификатором приюта -- Saves handler instance with specified name and phone, and shelter accordingly to provided shelterId")
    @GetMapping("/save/{name}/{phone}/{shelterId}")
    public Handler save(@Parameter(description = "Имя кинолога -- Dog trainer's name", example = "Петр") @PathVariable("name") String name,
                        @Parameter(description = "Телефон в строковом формате", example = "") @PathVariable("phone") String phone,
                        @Parameter(description = "Идентификатор приют для собак", example = "") @PathVariable() long shelterId) {
        return handlerService.saveHandler(name, phone, shelterId);
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "Удаление кинолога -- Deleting dog trainer",
            description = "Удаляет экземпляр класса handler c указанными именем и телефоном," +
                    " и приютом в соответствии с указанным индентификатором -- Deletes handler instance with specified name and phone, and shelter accordingly to provided shelterId")
    public Handler deleteHandler(@Parameter(description = "Идентификатор кинолога") @PathVariable("id") long id) {
        return handlerService.deleteHandlerById(id);
    }


    /**
     * Просмотр списка кинологов -- View dog trainer list
     */
    @GetMapping("/view")
    @Operation(summary = "Просмотр списка кинологов -- View dog trainer list",
            description = "Выводит список кинологов" +
                    " -- Displays dog trainer list")
    public List<Handler> viewHandlers() {
        return handlerService.findAllHandlers();
    }
}
