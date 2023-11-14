package pro.sky.botanimalshelter.volunteercrud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.service.HandlerService;

import java.util.List;

@RestController
@RequestMapping("/handler")
public class HandlerController {
    private final HandlerService handlerService;

    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @GetMapping("")
    public String welcome() {
        return "Добро пожаловать в контроллер кинолога! -- Welcome to Handler Controller!";
    }

    /**
     * Сохраняем кинолога -- Save dog trainer
     */
    @GetMapping("/save/{name}/{phone}/{shelterId}")
    public Handler save(@PathVariable("name") String name, @PathVariable("phone") String phone,
                        @PathVariable() long shelterId) {
        return handlerService.saveHandler(name, phone, shelterId);
    }

    @GetMapping("/delete/{id}")
    public Handler deleteHandler(@PathVariable("id") long id) {
        return handlerService.deleteHandlerById(id);
    }


    /**
     * Просмотр списка кинологов -- View dog trainer list
     */
    @GetMapping("/view")
    public List<Handler> viewHandlers() {
        return handlerService.findAllHandlers();
    }
}
