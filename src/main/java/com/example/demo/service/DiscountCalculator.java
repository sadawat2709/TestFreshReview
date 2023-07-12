package com.example.demo.service;

import org.springframework.stereotype.Component;

import static com.example.demo.utils.Utility.isBFCM;

@Component
public class DiscountCalculator {
    private static final int ORDER_COUNT_1 = 10;
    private static final int ORDER_COUNT_2 = 20;
    private static final double DISCOUNT_FOR_ORDER_COUNT_1 = 0.1;
    private static final double DISCOUNT_FOR_ORDER_COUNT_2 = 0.2;
    public double calculateDiscount(int orderCount) {
        double discount = 0;
        if(isBFCM()) {
            discount += 1.5;
        }
        if (orderCount > ORDER_COUNT_1 && orderCount <= ORDER_COUNT_2) {
            discount += DISCOUNT_FOR_ORDER_COUNT_1;
        } else if (orderCount > ORDER_COUNT_2) {
            discount += DISCOUNT_FOR_ORDER_COUNT_2;
        }
        return discount;
    }
}

