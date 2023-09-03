package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NhnMartTest {

    private NhnMart mart;

    @BeforeEach
    public void setUp() {
        mart = new NhnMart();
        mart.prepareMart();
    }

    @Test
    @DisplayName("FoodStrand 초기화 테스트")
    public void foodStandInitialTest() {
        assertEquals(2, countFoodInStand("양파"));
        assertEquals(5, countFoodInStand("계란"));
        assertEquals(10, countFoodInStand("파"));
        assertEquals(20, countFoodInStand("사과"));
    }

    @Test
    @DisplayName("고객 상품 선택 테스트")
    public void customerPickFoodsTest() {
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 1));
        buyList.add(new BuyList.Item("계란", 2));

        Customer customer = new Customer(buyList);
        customer.bring(mart.provideBasket());
        customer.pickFoods(mart.getFoodStand());

        assertEquals(1, countFoodInCustomerBasket(customer, "양파"));
        assertEquals(2, countFoodInCustomerBasket(customer, "계란"));
    }

    @Test
    @DisplayName("결제 테스트")
    public void CustomerPayTest() {
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 1));
        buyList.add(new BuyList.Item("계란", 2));

        Customer customer = new Customer(buyList);
        customer.bring(mart.provideBasket());
        customer.pickFoods(mart.getFoodStand());

        Counter counter = mart.getCounter();
        customer.payTox(counter);
    }

    private int countFoodInStand(String name) {
        int count = 0;
        for (Food food : mart.getFoodStand().getFoods()) {
            if (food.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    private int countFoodInCustomerBasket(Customer customer, String name) {
        int count = 0;
        for (Food food : customer.getBasket().getFoods()) {
            if (food.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }
}
