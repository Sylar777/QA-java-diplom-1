package praktikum;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class BurgerTest {

    private Burger burger;
    private List<Ingredient> ingredients;
    private final List<Ingredient> ingredientData = Arrays.asList(
        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
        new Ingredient(IngredientType.SAUCE, "chili sauce", 300)
    );

    @Mock
    Bun testBun;

    @Mock
    Ingredient ingredientTest;

    @Before
    public void setUp() {
        burger = new Burger();
        ingredients = new ArrayList<>();
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredientData.get(0));
        assertEquals(ingredientData.get(0), burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredientData.get(0));
        burger.addIngredient(ingredientData.get(1));
        burger.removeIngredient(0);
        assertEquals(ingredientData.get(1), burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredientData.get(0));
        burger.addIngredient(ingredientData.get(1));
        burger.moveIngredient(1, 0);
        assertEquals(ingredientData.get(1), burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(testBun.getPrice()).thenReturn(100.0f);
        burger.setBuns(testBun);

        float priceTest = testBun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            priceTest += ingredient.getPrice();
        }

        assertEquals(priceTest, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() throws Exception{
        Mockito.when(testBun.getName()).thenReturn("black bun");
        Mockito.when(testBun.getPrice()).thenReturn(100.0f);
        burger.setBuns(testBun);

        Mockito.when(ingredientTest.getName()).thenReturn("ingredient test name");
        Mockito.when(ingredientTest.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTest.getPrice()).thenReturn(100.0f);
        
        for(int i=0;i<3;i++){
            burger.addIngredient(ingredientTest);
            ingredients.add(ingredientTest);
        }

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", testBun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", testBun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(receipt.toString(), burger.getReceipt());
    }
}
