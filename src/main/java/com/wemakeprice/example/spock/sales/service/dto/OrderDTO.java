package com.wemakeprice.example.spock.sales.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private List<Item> items;

    @Getter
    @Setter
    public static class Item {
        private String productId;
        private int count;
    }
}
