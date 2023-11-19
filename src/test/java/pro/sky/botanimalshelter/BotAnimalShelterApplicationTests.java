package pro.sky.botanimalshelter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pro.sky.botanimalshelter.repository.BotAnimalShelterUserRepository;
import pro.sky.botanimalshelter.service.BotAnimalShelterService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BotAnimalShelterApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private BotAnimalShelterService botAnimalShelterService;

    @Autowired
    private TestRestTemplate restTemplate;

@Test
    public void workingBot() throws Exception{
    Assertions.assertThat(botAnimalShelterService).isNotNull();
}
}
