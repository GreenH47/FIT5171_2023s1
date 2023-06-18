package FIT5171.Team8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AirplaneCollectionTest {
    Airplane airplane1, airplane2;
    @BeforeEach
    void setup(){
        airplane1 = mock(Airplane.class);
        airplane2 = mock(Airplane.class);

        when(airplane1.getAirplaneID()).thenReturn(1);
        when(airplane2.getAirplaneID()).thenReturn(2);
    }

    @AfterEach
    void afterEach(){
        AirplaneCollection.airplanes.clear();
    }

    @Test
    void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<AirplaneCollection> constructor = AirplaneCollection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        AirplaneCollection instance = constructor.newInstance();
        assertNotNull(instance);
    }

    @Test
    void testAddAirplane(){
        AirplaneCollection.addAirplane(airplane1);
        AirplaneCollection.addAirplane(airplane2);

        assertEquals(2, AirplaneCollection.airplanes.size());
    }

    @Test
    void testAddAirplaneWithExistingAirplane(){
        Throwable exception;
        AirplaneCollection.addAirplane(airplane1);
        AirplaneCollection.addAirplane(airplane2);

        exception = assertThrows(RuntimeException.class, () -> {
            AirplaneCollection.addAirplane(airplane1);
        });
        assertEquals("1 is already existing.", exception.getMessage());
        assertEquals(2, AirplaneCollection.airplanes.size());
    }

    @Test
    void testGetAirplaneInfo(){
        AirplaneCollection.addAirplane(airplane1);
        AirplaneCollection.addAirplane(airplane2);

        assertEquals(airplane1, AirplaneCollection.getAirPlaneInfo(1));
        assertEquals(airplane2, AirplaneCollection.getAirPlaneInfo(2));
    }

    @Test
    void testGetNonExistentAirplaneInfo(){
        Throwable exception;
        exception = assertThrows(RuntimeException.class, () -> {
            AirplaneCollection.getAirPlaneInfo(1);
        });
        assertEquals("No such airplane exists.", exception.getMessage());

    }
}