package com.wemakeprice.example.spock.sales.service;

import com.wemakeprice.example.spock.sales.domain.Product;
import com.wemakeprice.example.spock.sales.service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl {
    private Map<String, Product> productMap;

    @PostConstruct
    private void initialize() {
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

        productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductId, Function.identity()));
    }

    public long calculate(OrderDTO orderDTO) {
        long amount = 0;
        for (OrderDTO.Item item : orderDTO.getItems()) {
            amount += productMap.get(item.getProductId()).getPrice();
        }
        return amount;
    }
}
