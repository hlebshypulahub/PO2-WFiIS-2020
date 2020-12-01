package com.company;

public class OptionNotRecognizedException extends Exception {
    private final char c;

    OptionNotRecognizedException(String message, char c) {
        super(message);
        this.c = c;
    }

    public char getC() {
        return c;
    }
}
