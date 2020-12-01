package com.company;

import javafx.util.Pair;

public class WallException extends Exception {
    private final int nx;
    private final int ny;

    WallException(String message, int ny, int nx) {
        super(message);
        this.nx = nx;
        this.ny = ny;
    }

    public String getPosition() {
        return "[" + ny + ", " + nx + "]";
    }
}
