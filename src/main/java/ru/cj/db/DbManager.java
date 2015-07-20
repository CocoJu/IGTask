package ru.cj.db;

import ru.cj.db.map.Product;

import java.util.ArrayList;
import java.util.List;

    public abstract class DbManager {

        abstract public List<Product> getProductsByConditions(
                String categoryContain, String nameContain,
                    Float priceFrom, Float priceBefore);

        static List<Product> filterProducts(
                List<Product> productList, String nameProd, String nameCategory) {
            List<Product> newProductList = new ArrayList<Product>();

            if(nameCategory == null && productList == null)
                return productList;

            for(Product product : productList){
                if(product.getCat().getName().matches(
                        ".*([ ]|^){1}" + nameCategory + "([ ]|$){1}.*") ||
                        product.getName().matches(
                                ".*([ ]|^){1}" + nameProd + "([ ]|$){1}.*"))
                    newProductList.add(product);
            }

            return newProductList;
        }
}
