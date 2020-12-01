package com.company;

public interface CheckStep {
    boolean test(char[][] board, int ny, int nx, int x0, int y0, Direction dir);
}
