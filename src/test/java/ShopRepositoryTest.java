import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();
    Product prod1 = new Product(1, "Футболка", 1_000);
    Product prod2 = new Product(2,"Джинсы", 3_000);
    Product prod3 = new Product(3,"Куртка", 5_000);
    Product prod4 = new Product(4, "Ботинки", 3_000);
    Product prod5 = new Product(5, "Шляпа", 1_000);

    @Test
    public void removedElement () {

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);
        repo.add(prod4);
        repo.add(prod5);

        repo.removeById(3);

        Product[] expected = { prod1, prod2, prod4, prod5 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removedNotExistElement () {

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);
        repo.add(prod4);
        repo.add(prod5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
}