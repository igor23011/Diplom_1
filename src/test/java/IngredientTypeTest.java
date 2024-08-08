import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void checkSauceNotNullTest() {
        assertNotNull("Может добавим соус к заказу?", IngredientType.SAUCE);
    }

    @Test
    public void checkFillingNotNullTest() {
        assertNotNull("Может выберем начинку к заказу?", IngredientType.FILLING);
    }
}