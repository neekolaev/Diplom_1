package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                { "black bun", 100.0f },
                { "white bun", 200.5f },
                { "red bun", 300.1f },
                { "", 0.0f },
                { "Очень длинное название для булочки чтобы проверить", 9999.99f }
        };
    }

    @Test
    public void getNameReturnsCorrectName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Метод getName() вернул некорректное имя.", bunName, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Метод getPrice() вернул некорректную цену.", bunPrice, bun.getPrice(), 0.0f);
    }
}