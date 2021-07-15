package com.wemakeprice.example.spock.sales.service

import com.wemakeprice.example.spock.sales.service.dto.OrderDTO
import com.wemakeprice.example.spock.sales.store.ProductStoreImpl
import spock.lang.Shared
import spock.lang.Specification

class OrderServiceTest extends Specification {

    @Shared
    private OrderServiceImpl orderService
    @Shared
    private ProductStoreImpl productStore

    def setupSpec() {
        productStore = new ProductStoreImpl()
        orderService = new OrderServiceImpl(productStore)
    }

    def "A 상품 3개, B 상품 1구매 시 1800 결과 테스트"() {
        given:
        def orderDTO = new OrderDTO()
        List<OrderDTO.Item> items = new ArrayList<>()

        items.add(new OrderDTO.Item(
                productId: "A",
                count: 3
        ))
        items.add(new OrderDTO.Item(
                productId: "B",
                count: 1
        ))

        orderDTO.setItems(items)

        when:
        def result = orderService.calculate(orderDTO)

        then:
        result == 18000
    }

    def "A 상품 -1 이 들어왔을 경우 정상 예외 처리"() {
        given:
        def orderDTO = new OrderDTO()
        List<OrderDTO.Item> items = new ArrayList<>()

        items.add(new OrderDTO.Item(
                productId: "A",
                count: -1
        ))
        orderDTO.setItems(items)

        when:
        orderService.calculate(orderDTO)

        then:
        def e = thrown(RuntimeException)
        e.message == "0봊다 작은 수가 입력되었습니다."
    }

    def "F 상품이 들어왔을 경우 예외 처리"() {

    }
}
