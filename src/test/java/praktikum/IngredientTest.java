package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    private Ingredient ingredientTest; 
    public IngredientType type = IngredientType.SAUCE;
    public final String nameTest = "nameTest";
    public final float priceTest = 10.0f;

    @Before
    public void setup(){
        ingredientTest = new Ingredient(type,nameTest, priceTest);
    }

    @Test
    public void getNameTest(){
        assertEquals(nameTest, ingredientTest.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(priceTest, ingredientTest.getPrice(),0);
    }

    @Test
    public void getTypeTest(){
        assertEquals(type, ingredientTest.getType());
    }
}
