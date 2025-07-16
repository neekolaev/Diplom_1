package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Готовим тестовые данные для разных ингредиентов
    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100f },
                { IngredientType.FILLING, "cutlet", 200f },
                { IngredientType.SAUCE, "chili sauce", 300.5f },
                { IngredientType.FILLING, "dinosaur", 0f }
        };
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента некорректна", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя ингредиента некорректно", name, ingredient.getName());
    }

    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента некорректен", type, ingredient.getType());
    }
}