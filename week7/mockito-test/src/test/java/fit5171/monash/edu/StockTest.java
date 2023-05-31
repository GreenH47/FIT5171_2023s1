package fit5171.monash.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
//import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(MockitoJUnitRunner.class)
class StockTest {
    Stock myMock = Mockito.mock(Stock.class);
    //when(myMock.getName()).thenReturn("My stock");

    Stock myRealObject = new Stock("1", "My Stock", 10);
    Stock mySpy = Mockito.spy(myRealObject);
    //when(mySpy.getId()).thenReturn("2");


    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getName() {
        //when(stock.getName()).thenReturn("expected");
    }

    @Test
    void setName() {
    }

    @Test
    void getQuantity() {
    }

    @Test
    void setQuantity() {
    }
}