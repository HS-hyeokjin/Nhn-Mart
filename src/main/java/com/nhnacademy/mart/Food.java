package com.nhnacademy.mart;

/**
 * 음식에대한 이름과 가격 클래스.
 *
 * @author hyeokjin
 */
public class Food {

    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
