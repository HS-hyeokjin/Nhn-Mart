package com.nhnacademy.mart;

/**
 * 고객을 나타내는 클래스. 고객의 돈, 장바구니, 구매 목록 등의 정보를 가지고 있다.
 *
 * @Author hyeokjin
 */
public class Customer {

    private final int money = 20_000;
    private int remainingMoney = money;

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    /**
     * 장바구니에 담는 메서드.
     *
     * @param stand 음식대
     */
    public void pickFoods(FoodStand stand) {
        for (BuyList.Item item : buyList.getItems()) {
            for (int i = 0; i < item.getAmount(); i++) {
                Food food = stand.getFood(item.getName());
                if (food == null) {
                    System.out.println(item.getName() + " 상품은 매대에 없습니다.");
                    continue;
                }
                try {
                    basket.add(food);
                    stand.remove(food);
                } catch (Exception e) {
                    System.out.println("오류: " + e.getMessage());
                }
            }
        }
    }

    /**
     * 카운터에서 돈을 지불하는 메서드.
     *
     * @param counter 계산대
     */
    public void payTox(Counter counter) {
        int total = 0;
        for (Food food : basket.getFoods()) {
            total += food.getPrice();
        }
        try {
            if (remainingMoney < total) {
                throw new Exception("보유한 돈이 부족합니다.");
            }
            counter.pay(this, total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 지정된 금액을 차감하고, 남은 잔액을 출력한다.
     *
     * @param amount 차감할 금액
     */
    public void deductMoney(int amount) {
        remainingMoney -= amount;
        System.out.println("총 가격은 " + amount + "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : " + remainingMoney);
    }

    public Basket getBasket() {
        return basket;
    }
}
