package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testEnumValues() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}