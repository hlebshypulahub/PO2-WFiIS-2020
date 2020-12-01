package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int n = 15;

        for (int i = 0; i <= n; i++) {
            double a = round(Math.sqrt(i), 6);
            if(Math.pow(a, 2) != i) {
                System.out.println(i);
            }
        }

    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
