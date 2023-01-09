package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredientTest; 
    private IngredientType type = IngredientType.SAUCE;
    public final String nameTest = "nameTest";
    public final float priceTest = 10.0f;

    public IngredientTest(IngredientType type){
        this.type = type;
    }

    @Parameterized.Parameters(name = "IngredientType: {0}")
    public static Object[][] params() {
        return new Object[][] {
                { IngredientType.SAUCE },
                { IngredientType.FILLING }
        };
    }

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
