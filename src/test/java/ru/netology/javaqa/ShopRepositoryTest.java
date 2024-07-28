package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11,"юбка",275);
    Product product2 = new Product(19,"брюки",437);
    Product product3 = new Product(34,"блуза",179);
    @Test
    public void testDeletingAnElement() {
      ShopRepository repo = new ShopRepository();
      repo.add(product1);
      repo.add(product2);
      repo.add(product3);
      Assertions.assertThrows(NotFoundException.class, () -> {
          repo.removeById(4);
      });
    }
    @Test
    public void testElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] expected = {product1,product2,product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testDeleteElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(product1.getId());
        Product[] expected = {product2,product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
}
