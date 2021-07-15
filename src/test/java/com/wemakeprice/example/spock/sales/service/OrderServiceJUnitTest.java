package com.wemakeprice.example.spock.sales.service;

import com.wemakeprice.example.spock.sales.service.dto.OrderDTO;
import com.wemakeprice.example.spock.sales.store.ProductStoreImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceJUnitTest {

    private static OrderServiceImpl orderService;
    private static ProductStoreImpl productStore;

    @BeforeAll
    public static void setupSpec() {
        productStore = new ProductStoreImpl();
        orderService = new OrderServiceImpl(productStore);
    }

    @Test
    @DisplayName("A 상품 3개, B 상품 1구매 시 1800 결과 테스트")
    void normalTest() {
        // given
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDTO.Item> items = new ArrayList<>();
        OrderDTO.Item productA = new OrderDTO.Item();
        productA.setProductId("A");
        productA.setCount(3);
        items.add(productA);

        OrderDTO.Item productB = new OrderDTO.Item();
        productB.setProductId("A");
        productB.setCount(3);
        items.add(productB);

        orderDTO.setItems(items);

        // when
        final long result = orderService.calculate(orderDTO);

        // then
        assertEquals(18000, result);
    }
}
