package com.wemakeprice.example.spock.sales.service;

import com.wemakeprice.example.spock.sales.domain.Product;
import com.wemakeprice.example.spock.sales.service.dto.OrderDTO;
import com.wemakeprice.example.spock.sales.store.ProductStoreImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {
    private final ProductStoreImpl productStore;

    public long calculate(OrderDTO orderDTO) {
        final List<Product> products = productStore.findAll();
        final Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductId, Function.identity()));

        long amount = 0;
        for (OrderDTO.Item item : orderDTO.getItems()) {
            if (item.getCount() <= 0) {
                throw new RuntimeException("0봊다 작은 수가 입력되었습니다.");
            }

            amount += productMap.get(item.getProductId()).getPrice() * item.getCount();
        }
        return amount;
    }
}
