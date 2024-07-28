package ru.netology.javaqa;

public class ShopRepository {
    private Product[] products = new Product[0];
    /*вспомогательный элемент для имитации добавления элемента в массив,
    current - массив, в который мы хотим добавить элемент,
    product - элемент, который мы хотим добавить,return возвращает новый массив,
     который выглядит как тот,
    что мы передали, но с добавлением нового элемента В КОНЕЦ! */

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /*метод добавления товара в репозиторий, product - добавляемый товар*/
    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }
    public Product findById(int id) {
        for (Product product : products) {
            if(id == product.getId()) {
                return product;
            }
        }
        return null;
    }
    public void removeById(int id) {
        if(findById(id)==null) {
            throw new NotFoundException(
              "Element with id:" +id + " not found"
            );
        }
    }

    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if(product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
