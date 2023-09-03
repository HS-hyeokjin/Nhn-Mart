package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 사야할 상풀 리스트를 나타내는 클래스.
 *
 * @author hyeokjin
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성
    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * 구매 리스트의 항목을 나타내는 내부 클래스.
     */
    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
