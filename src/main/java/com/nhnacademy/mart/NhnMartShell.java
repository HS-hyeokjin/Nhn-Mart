package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * nhn마트 Main 클래스.
 *
 * @author hyeokjin
 */
public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    /**
     * nhn마트 실행.
     * buyList를 입력받고 basket을 이용하여 결제.
     */
    public static void main(String[] args) {
        logger.info("NhnMart 실행.");

        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();
        logger.info("BuyList 입력 받음: {} 아이템.", buyList.getItems().size());

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer hyokjin = new Customer(buyList);
        logger.debug("고객 생성.");

        // 장바구니를 챙긴다.
        hyokjin.bring(mart.provideBasket());
        logger.info("장바구니를 챙긴다.");


        // 식품을 담는다.
        hyokjin.pickFoods(mart.getFoodStand());
        logger.info("식품을 담는다.");

        // 카운터에서 계산한다.
        hyokjin.payTox(mart.getCounter());
        logger.info("카운터에서 계산한다.");

    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        Scanner scanner = new Scanner(System.in);
        BuyList buyList = new BuyList();

        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i += 2) {
            buyList.add(new BuyList.Item(arr[i], Integer.parseInt(arr[i + 1])));
        }
        return buyList;
    }
}