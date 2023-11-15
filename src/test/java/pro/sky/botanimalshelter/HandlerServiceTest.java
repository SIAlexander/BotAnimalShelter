package pro.sky.botanimalshelter;

import liquibase.pro.packaged.H;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.botanimalshelter.model.Handler;
import pro.sky.botanimalshelter.model.PetShelter;
import pro.sky.botanimalshelter.repository.HandlerRepository;
import pro.sky.botanimalshelter.service.HandlerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class HandlerServiceTest {

    final private Logger logger = LoggerFactory.getLogger(HandlerServiceTest.class);

    @Mock
    private HandlerRepository handlerRepositoryMock;

    @InjectMocks
    private HandlerService handlerServiceMocked;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }

    private static PetShelter getRightPetShelter() {
        final PetShelter rightPetShelter = new PetShelter();
        rightPetShelter.setName("Right Pet Shelter");
        rightPetShelter.setId(1L);
        return rightPetShelter;
    }

    private static Handler getHandler(long id) {
        long l = id * 1111111;
        String phone = String.valueOf(l);
        String name = "Name" + id;
        Handler handler = new Handler(name, phone, getRightPetShelter());
        handler.setId(id);
        return handler;
    }

    @Test
    public void saveHandlerEntityTest() {
        Handler handler = getHandler(1);
        assertThrows(RuntimeException.class, () -> handlerServiceMocked.saveHandler(null));
        when(handlerRepositoryMock.save(handler)).thenReturn(handler);
        assertEquals(handler, handlerRepositoryMock.save(handler));
        assertEquals(handler, handlerServiceMocked.saveHandler(handler));
    }

    @Test
    public void saveHandlerArgsTest() {

        PetShelter rightPetShelter = getRightPetShelter();

        final Handler rightHandler = new Handler("Right", "111-111-1111", rightPetShelter);
        rightHandler.setId(1L);

        logger.info(rightHandler.toString());

        assertThrows(RuntimeException.class,
                () -> handlerServiceMocked.saveHandler("", "112", 1));

        logger.info(handlerServiceMocked.toString());

    }

}
