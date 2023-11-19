package pro.sky.botanimalshelter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pro.sky.botanimalshelter.service.BotAnimalShelterService;
import pro.sky.botanimalshelter.service.Keyboard;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KeyboardTests {
    @LocalServerPort
    private int port;

    @Autowired
    private Keyboard keyboard;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public  void keyboardSelectionShelter() throws Exception{
        Assertions.assertThat(keyboard).isNotNull();
    }
}
