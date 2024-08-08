import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient sauceMock;
    @Mock
    private Ingredient fillingMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(bunMock.getName()).thenReturn("bread");
        when(bunMock.getPrice()).thenReturn(10f);
        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceMock.getName()).thenReturn("tar-tar");
        when(sauceMock.getPrice()).thenReturn(5f);
        when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
        when(fillingMock.getName()).thenReturn("chicken");
        when(fillingMock.getPrice()).thenReturn(20f);

        burger = new Burger();
        burger.setBuns(bunMock);
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
    }

    @Test
    public void checkSetBunsTest() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void checkAddIngredientTest() {
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        String expected = String.format(
                        "(==== bread ====)%n" +
                        "= sauce tar-tar =%n" +
                        "= filling chicken =%n" +
                        "= sauce tar-tar =%n" +
                        "= filling chicken =%n" +
                        "(==== bread ====)%n" +
                        "%n" +
                        "Price: 70,000000%n");
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void checkRemoveIngredientTest() {
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        String expected = String.format(
                        "(==== bread ====)%n" +
                        "(==== bread ====)%n" +
                        "%n" +
                        "Price: 20,000000%n");
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void checkMoveIngredientTest() {
        burger.moveIngredient(0, 1);
        String expected = String.format(
                        "(==== bread ====)%n" +
                        "= filling chicken =%n" +
                        "= sauce tar-tar =%n" +
                        "(==== bread ====)%n" +
                        "%n" +
                        "Price: 45,000000%n");
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void checkGetPriceTest() {
        assertEquals(45f, burger.getPrice(), 0.01);
    }

    @Test
    public void checkGetRecipeTest() {
        String expected = String.format(
                        "(==== bread ====)%n" +
                        "= sauce tar-tar =%n" +
                        "= filling chicken =%n" +
                        "(==== bread ====)%n" +
                        "%nPrice: 45,000000%n");
         assertEquals(expected, burger.getReceipt());
    }

}