package com.company;

public class StackUnderflowException extends Exception {

    private final int index;

    StackUnderflowException(String msg, int index) {
        super(msg);
        this.index = index;
    }

    public String getIndex() {
        return "Index " + index + "; ";
    }
}
