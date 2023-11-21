package pro.sky.botanimalshelter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pro.sky.botanimalshelter.service.KeyboardService;
import pro.sky.botanimalshelter.service.PetShelterService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PetShelterServiceTests {
    @LocalServerPort
    private int port;

    @Autowired
    private PetShelterService petShelterService;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public  void keyboardSelectionShelter() throws Exception{
       Assertions.assertThat(petShelterService).isNotNull();
    }
}
