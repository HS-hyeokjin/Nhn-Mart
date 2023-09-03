package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 장바구니 클래스.
 *
 * @author hyeokjin
 */
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

}