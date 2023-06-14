package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Хлеб", 30);
    Product item2 = new Product(2, "Молоко", 80);
    Product item3 = new Product(3, "Кефир", 35);
    Product item4 = new Product(4, "Йогурт", 50);

    @Test
    public void RemoveElementPositive() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(item1);
        shopRepository.add(item2);
        shopRepository.add(item3);
        shopRepository.add(item4);
        shopRepository.removeById(item1.getId());

        Product[] actual = shopRepository.findAll();
        Product[] expected = {item2, item3, item4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveElementNegative() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(item1);
        shopRepository.add(item2);
        shopRepository.add(item3);
        shopRepository.add(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(5);
        });
    }
}
