package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void setBunsSetsTheBun() {
        assertEquals("Булочка не была установлена", mockBun, burger.bun);
    }

    @Test
    public void addIngredientAddsToTheList() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Ингредиент не был добавлен", 1, burger.ingredients.size());
        assertEquals("Добавлен неверный ингредиент", mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesFromTheList() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0); // Удаляем первый
        assertEquals("Ингредиент не был удален", 1, burger.ingredients.size());
        assertEquals("Удален неверный ингредиент", mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientMovesCorrectly() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1); // Перемещаем первый на место второго
        assertEquals("Порядок ингредиентов после перемещения неверен", mockIngredient2, burger.ingredients.get(0));
        assertEquals("Порядок ингредиентов после перемещения неверен", mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceCalculatesCorrectly() {
        when(mockBun.getPrice()).thenReturn(125.5f); // 1 булочка
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(100f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 401.0f;
        assertEquals("Расчет итоговой цены неверен", expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptGeneratesCorrectly() {
        when(mockBun.getName()).thenReturn("Флюоресцентная булка");
        when(mockBun.getPrice()).thenReturn(100f); // цена булочки
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Соус галактический");
        when(mockIngredient1.getPrice()).thenReturn(50f); // цена соуса

        burger.addIngredient(mockIngredient1);


        String receipt = burger.getReceipt();

        assertTrue("Чек должен содержать название булочки", receipt.contains("Флюоресцентная булка"));
        assertTrue("Чек должен содержать тип и название ингредиента", receipt.contains("= sauce Соус галактический ="));
        assertTrue("Чек должен содержать итоговую цену", receipt.contains("Price: 250"));
    }
}