package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class DatabaseTest {

    @Test
    public void availableBunsReturnsNonEmptyList() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertNotNull("Список булочек не должен быть null", buns);
        assertFalse("Список булочек не должен быть пустым", buns.isEmpty());
    }

    @Test
    public void availableIngredientsReturnsNonEmptyList() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull("Список ингредиентов не должен быть null", ingredients);
        assertFalse("Список ингредиентов не должен быть пустым", ingredients.isEmpty());
    }
}