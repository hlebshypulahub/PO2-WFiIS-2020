package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Complex complex = new Complex();
        complex.test();
        System.out.println();

        ///////////////////////////////////////////////////////////

        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.valueOf(args[2]);

        double delta = Math.pow(b, 2) - 4 * a * c;

        Complex x1 = Complex.divide((Complex.add(new Complex(-b), Complex.sqrt(delta))), new Complex(2 * a));
        Complex x2 = Complex.divide((Complex.subtract(new Complex(-b), Complex.sqrt(delta))), new Complex(2 * a));

        System.out.println("x1 = " + x1 + ", x2 = " + x2);


    }
}
