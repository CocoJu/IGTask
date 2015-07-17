package ru.cj.db;

import ru.cj.db.map.Product;

import java.util.List;

    public interface DbManager {
        List<Product> getProductsByConditions(
                String nameContain, Float priceFrom, Float priceBefore);
}
