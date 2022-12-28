package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private Bun bunTest; 
    private final String nameTest = "bunTest";
    private final float priceTest = 10.0f;

    @Before
    public void setup(){
        bunTest = new Bun(nameTest, priceTest);
    }

    @Test
    public void getNameTest(){
        assertEquals(nameTest, bunTest.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(priceTest, bunTest.getPrice(),0);
    }

    
}
