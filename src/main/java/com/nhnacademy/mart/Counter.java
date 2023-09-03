package com.nhnacademy.mart;

/**
 * 계산처리를 받아줄 데스크 클래스.
 *
 * @author hyeokjin
 */
public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public void pay(Customer customer, int amount) {
        customer.deductMoney(amount);
    }

}
