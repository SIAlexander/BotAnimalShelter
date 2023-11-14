package pro.sky.botanimalshelter.volunteercrud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.botanimalshelter.service.HandlerService;

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
}
