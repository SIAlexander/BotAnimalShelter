package pro.sky.botanimalshelter.serviceTest;

import org.junit.jupiter.api.Test;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import pro.sky.botanimalshelter.service.KeyboardService;

import static org.mockito.Mockito.*;

class KeyboardServiceTest {


    @Test
    public void testKeyboardSelectionShelter() {
        // Mock TelegramBot
        TelegramBot telegramBot = mock(TelegramBot.class);
        KeyboardService keyboardService = new KeyboardService(telegramBot);

        // Call the method to test
        keyboardService.keyboardSelectionShelter(123L);

        // Verify the callbackData is set correctly for the buttons
        // verify(KeyboardService.DOG_SHELTER).callbackData("/dog");
        verify(KeyboardService.DOG_SHELTER).callbackData("/dog");
        verify(KeyboardService.CAT_SHELTER).callbackData("/cat");

        // Verifying that the addRow method is called with the correct buttons
        InlineKeyboardMarkup expectedMarkup = new InlineKeyboardMarkup();
        expectedMarkup.addRow(KeyboardService.DOG_SHELTER, KeyboardService.CAT_SHELTER);
        verify(telegramBot).execute(any(SendMessage.class));
    }
}
