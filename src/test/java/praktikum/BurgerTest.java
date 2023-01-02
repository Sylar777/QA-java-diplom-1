package praktikum;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {

    Burger burger;
    private List<Ingredient> ingredients;
    private final List<Ingredient> ingredientData = Arrays.asList(
        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
        new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
        new Ingredient(IngredientType.FILLING, "dinosaur", 200),
        new Ingredient(IngredientType.FILLING, "sausage", 300)
    );
    private final Bun testBun = new Bun("black bun", 100);;

    @Before
    public void setUp() {
        burger = new Burger();
        ingredients = new ArrayList<>();

        burger.addIngredient(ingredientData.get(0));
        burger.addIngredient(ingredientData.get(1));
        burger.addIngredient(ingredientData.get(2));
        burger.addIngredient(ingredientData.get(3));

        burger.setBuns(new Bun("black bun", 100));

        ingredients.add(ingredientData.get(0));
        ingredients.add(ingredientData.get(1));
        ingredients.add(ingredientData.get(2));
        ingredients.add(ingredientData.get(3));
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(0);
        assertEquals(ingredientData.get(1), burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(2, 1);
        assertEquals(ingredientData.get(2), burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest(){

        float priceTest = testBun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            priceTest += ingredient.getPrice();
        }

        assertEquals(priceTest, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() throws Exception{
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
