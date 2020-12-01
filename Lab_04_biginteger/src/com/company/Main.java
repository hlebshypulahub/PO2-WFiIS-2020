package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        long l1;
        long l2;
        BigInt bi;
        int i = 1;

        //// Test 1-1000
        while (i <= 1000) {
            l1 = Math.abs(new Random().nextLong());
            l2 = Math.abs(new Random().nextLong());
            try {
                bi = BigInt.checkAdd(l1, l2);
                System.out.println("(" + i + ")Longs : " + l1 + " + " + l2 + " = " + (l1 + l2));
                System.out.println("(" + i + ")BigInt: " + l1 + " + " + l2 + " = " + bi + "\n");
                i++;
            } catch (Exception ignore) {
            }
        }

        //// Test 1001
        l1 = 999999999999999999L;
        l2 = 1L;
        BigInt.tryCatch(l1, l2, i++);

        //// Test 1002
        l1 = 1L;
        l2 = 999999999999999999L;
        BigInt.tryCatch(l1, l2, i++);

        //// Test 1003
        l1 = Long.MAX_VALUE - 1;
        l2 = 1L;
        BigInt.tryCatch(l1, l2, i++);

        //// Test 1004
        l1 = Long.MAX_VALUE;
        l2 = 0L;
        BigInt.tryCatch(l1, l2, i++);

        //// Test 1005
        l1 = Long.MAX_VALUE;
        l2 = 1L;
        BigInt.tryCatch(l1, l2, i);


        ///// Kalkulator dużych liczb /////

        Scanner sc = new Scanner(System.in);
        System.out.print("To run calculator type 'r' ('x' to exit): ");
        String state = sc.nextLine();
        System.out.println();
        if (state.equals("r")) {
            while (true) {
                sc = new Scanner(System.in);
                System.out.print("Enter first number ('x' to exit): ");
                String s1 = sc.nextLine();
                if (s1.equals("x")) {
                    break;
                }
                System.out.print("Enter second number ('x' to exit): ");
                String s2 = sc.nextLine();
                if (s2.equals("x")) {
                    break;
                }
                System.out.println(s1 + " + " + s2 + " = ");
                System.out.println(new BigInt(new BigInt(s1).add(new BigInt(s2))) + "\n");
            }
        } else if (state.equals("x")) {
            System.exit(0);
        }
    }
}
