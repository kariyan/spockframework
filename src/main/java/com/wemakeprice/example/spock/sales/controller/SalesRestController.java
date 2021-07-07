package com.wemakeprice.example.spock.sales.controller;

import com.wemakeprice.example.spock.sales.service.OrderServiceImpl;
import com.wemakeprice.example.spock.sales.service.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SalesRestController {
    private final OrderServiceImpl orderService;

    @PostMapping("/order")
    public long order(@RequestBody OrderDTO orderDTO) {
        return orderService.calculate(orderDTO);
    }
}
