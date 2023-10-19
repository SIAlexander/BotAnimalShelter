package pro.sky.botanimalshelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotAnimalShelterUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(BotAnimalShelterUpdatesListener.class);

    private final TelegramBot telegramBot;

    public BotAnimalShelterUpdatesListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            //Обрабатываем свои обновления здесь
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
