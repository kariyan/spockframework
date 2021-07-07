# Spock Test Framework

## 서비스 개요
주문을 받아 총 주문의 총액을 출력하는 서비스입니다. 

## 준비 사항
상품은 3가지가 준비되어 있습니다. 

- A: 500원
- B: 300원
- C: 800원

## 실행 방법

```
POST http://localhost:8080/order
Content-Type: application/json

{
  "items": [
    {
      "productId": "A",
      "count": 3
    },
    {
      "productId": "B",
      "count": 1
    }
  ]
}
```

## 실행 결과

> 800

## 목적
서비스의 테스트 코드를 작성하세요.

1. 정상적인 테스트
1. 예외 테스트
