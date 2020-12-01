package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] strArr = splitArgs(args[0]);

        System.out.println(strArr);


    }

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).
                filter(w -> !w.isEmpty()).toArray(String[]::new);
    }
}
