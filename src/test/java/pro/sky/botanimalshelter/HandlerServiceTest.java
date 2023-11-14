package pro.sky.botanimalshelter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.HandlerRepository;
import pro.sky.botanimalshelter.service.HandlerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class HandlerServiceTest {

    final private Logger logger = LoggerFactory.getLogger(HandlerServiceTest.class);

    @Mock
    private HandlerRepository handlerRepositoryMock;

    @InjectMocks
    private HandlerService handlerServiceMocked;

    @Test
    public void saveHandlerEntityTest() {
        assertThrows(RuntimeException.class, () -> handlerServiceMocked.saveHandler(null));
    }

    @Test
    public void saveHandlerArgsTest() {

        PetShelter rightPetShelter = new PetShelter();

        rightPetShelter.setName("Right Pet Shelter");
        rightPetShelter.setId(1L);

        final Handler rightHandler = new Handler("Right", "111-111-1111", rightPetShelter);
        rightHandler.setId(1L);

        assertThrows(RuntimeException.class,
                () -> handlerServiceMocked.saveHandler("", "112", 1));

        logger.info(handlerServiceMocked.toString());

//        when(handlerRepositoryMock.save(any(Handler.class))).thenReturn(rightHandler);
//        assertEquals(rightHandler, handlerServiceMocked.saveHandler(rightHandler));

    }

}
