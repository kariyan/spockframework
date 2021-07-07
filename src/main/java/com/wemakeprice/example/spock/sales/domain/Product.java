package com.wemakeprice.example.spock.sales.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private String productId;
    private Long price;
}
