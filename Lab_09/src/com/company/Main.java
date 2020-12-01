package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        try {
            String[] strArr = splitArgs(args[0]);
            Object o = new Object();
            Class<?> c = Class.forName("java.lang.Math");
            double result;
            Method methodCall;
            double x = 0.0;
            double y = 0.0;

            if (strArr.length == 2) {
                try {
                    x = Double.parseDouble(strArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Argumenty funkcji musza byc liczbami!");
                    System.exit(0);
                }

                methodCall = c.getDeclaredMethod(strArr[0], double.class);
                result = (double) methodCall.invoke(o, x);
                System.out.println(args[0] + " = " + result);
            } else if (strArr.length == 3) {
                try {
                    x = Double.parseDouble(strArr[1]);
                    y = Double.parseDouble(strArr[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Argumenty funkcji musza byc liczbami!");
                    System.exit(0);
                }

                methodCall = c.getDeclaredMethod(strArr[0], double.class, double.class);
                result = (double) methodCall.invoke(o, x, y);
                System.out.println(args[0] + " = " + result);
            } else {
                throw new IllegalStateException("Zla liczba argumentow funkcji! " +
                        "Podaj jedna lub dwie liczby");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("Nie ma takiej metody!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie podano nic do obliczenia");
        }
    }

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).
                filter(w -> !w.isEmpty()).toArray(String[]::new);
    }
}
