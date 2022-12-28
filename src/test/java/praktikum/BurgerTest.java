package praktikum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {
    Burger burdger;
    Database database;
    private List<Ingredient> ingredients;
    Bun testBun;

    @Before
    public void setUp() {
        burdger = new Burger();
        database = new Database();
        ingredients = new ArrayList<>();
        testBun = database.availableBuns().get(0);

        burdger.addIngredient(database.availableIngredients().get(1));
        burdger.addIngredient(database.availableIngredients().get(2));
        burdger.addIngredient(database.availableIngredients().get(4));
        burdger.addIngredient(database.availableIngredients().get(5));

        burdger.setBuns(testBun);
        
        ingredients.add(database.availableIngredients().get(1));
        ingredients.add(database.availableIngredients().get(2));
        ingredients.add(database.availableIngredients().get(4));
        ingredients.add(database.availableIngredients().get(5));
    }

    @Test
    public void BurgerTest(){
        float priceTest = database.availableBuns().get(0).getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            priceTest += ingredient.getPrice();
        }

        assertEquals(priceTest, burdger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() throws Exception{
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", testBun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", testBun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burdger.getPrice()));

        assertEquals(receipt.toString(), burdger.getReceipt());
    }
}
