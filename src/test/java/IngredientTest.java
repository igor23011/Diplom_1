import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Вариант начинки и соуса: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "Spicy-X", 90},
                {SAUCE, "Соус фирменный Space Sauce", 80},
                {SAUCE, "Соус традиционный галактический", 15},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                {FILLING, "Говяжий метеорит (отбивная)", 3000},
                {FILLING, "Биокотлета из марсианской Манголии", 424},
                {FILLING, "Филе люминесцентного тетраодонтимформа", 988},
                {FILLING, "Хрустящие минеральные кольца", 300},
                {FILLING, "Плоды Фалленианского дерева", 874},
                {FILLING, "Кристаллы марсианских альфа-сахаридов", 762},
                {FILLING, "Мини-салат Экзо-Плантаго", 4400},
                {FILLING, "Сыр с астероидной плесенью", 4142}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void checkGetNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }
}