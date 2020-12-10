package com.company;

public class StackOverflowException extends Exception {

    private final int size;
    private final int index;

    StackOverflowException(String msg, int size, int index) {
        super(msg);
        this.size = size;
        this.index = index;
    }

    public String getSize() {
        return "Size " + size + "; ";
    }

    public String getIndex() {
        return "Index " + index + "; ";
    }
}
