package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * nhn마트의 상품 스탠드 클래스.
 *
 * @author hyeokjin
 */
public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    /**
     * 상품 스탠드에 음식을 추가합니다.
     *
     * @param food 추가할 음식
     */
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * 상품 스탠드에서 특정 음식을 제거합니다.
     *
     * @param food 제거할 음식
     */
    public void remove(Food food) {
        if (!foods.contains(food)) {
            System.out.println(food.getName() + " 상품의 재고가 부족합니다.");
            return;
        }
        foods.remove(food);
    }

    /**
     * 상품 스탠드에서 특정 이름의 음식을 검색하여 반환합니다.
     *
     * @param name 검색할 음식의 이름
     */
    public Food getFood(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
