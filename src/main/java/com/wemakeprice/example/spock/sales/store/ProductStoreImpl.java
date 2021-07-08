package com.wemakeprice.example.spock.sales.store;

import com.wemakeprice.example.spock.sales.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductStoreImpl {
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .productId("A")
                .price(500L)
                .build());
        products.add(Product.builder()
                .productId("B")
                .price(300L)
                .build());
        products.add(Product.builder()
                .productId("C")
                .price(800L)
                .build());
        return products;
    }
}
