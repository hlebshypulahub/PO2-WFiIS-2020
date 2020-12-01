package com.company;

import java.util.Arrays;
import java.util.Random;

public class Game {
    private char[][] board;
    private final int nx;
    private final int ny;
    private int x0;
    private int y0;
    private final int xWin;
    private final int yWin;
    private final double p = 0.3;
    private final char hero = '•';
    private final char brick = '█';
    private final CheckStep checkWall = (char[][] b, int ny, int nx, int x0, int y0, Direction dir)
            -> b[y0 + dir.getY()][x0 + dir.getX()] != ' ';
    private final CheckStep checkOutOfBounds = (char[][] b, int ny, int nx, int x0, int y0, Direction dir)
            -> y0 + dir.getY() >= ny || y0 + dir.getY() < 0
            || x0 + dir.getX() >= nx || x0 + dir.getX() < 0;

    Game(int nx, int ny) {
        this.nx = nx;
        this.ny = ny;
        xWin = nx / 2;
        yWin = 0;
    }

    public final double getP() {
        return p;
    }

    public final int getX0() {
        return x0;
    }

    public final int getY0() {
        return y0;
    }

    public void setX0(int x) {
        x0 = x;
    }

    public void setY0(int y) {
        y0 = y;
    }

    public void buildBoard() {
        board = new char[ny][nx];

        for (char[] row : board)
            Arrays.fill(row, brick);

        board[yWin][xWin] = ' ';

        boolean done = false;
        for (int i = 0; i < ny; i++)
            for (int j = 0; j < nx; j++) {
                Random random = new Random();
                double r = random.nextDouble();
                if (r > getP())
                    board[i][j] = ' ';
                if (board[i][j] == ' ' && !done) {
                    board[i][j] = hero;
                    x0 = j;
                    y0 = i;
                    done = true;
                }
            }

        done = false;
        if (!hasHero()) {
            for (int i = ny - 2; i >= 1; i--)
                for (int j = nx - 2; j >= 0; j--) {
                    if (board[i][j] == ' ' && !done) {
                        board[i][j] = hero;
                        x0 = j;
                        y0 = i;
                        done = true;
                    }
                }
            if (!done) {
                System.out.println("Zly labirynt, nacisnij reset ('0').");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void step(Direction dir) throws WallException {
        if (checkOutOfBounds.test(board, ny, nx, x0, y0, dir))
            throw new IndexOutOfBoundsException("BLAD: Proba wyjscia poza plansze!");

        // check.test(board, x0, y0, dir)
        if (checkWall.test(board, ny, nx, x0, y0, dir))
            throw new WallException("BLAD: Proba wejcia na zabronione pole na pozycji: ",
                    y0 + dir.getY(), x0 + dir.getX());

        int x1 = getX0() + dir.getX();
        int y1 = getY0() + dir.getY();
        move(x1, y1);
        setX0(x1);
        setY0(y1);
    }

    public void move(int x1, int y1) {
        board[y0][x0] = ' ';
        board[y1][x1] = '•';
    }

    public boolean hasHero() {
        boolean found = false;
        for (int i = ny - 1; i >= 0; i--)
            for (int j = nx - 1; j >= 0; j--) {
                if (board[i][j] == hero && !found) {
                    found = true;
                    break;
                }
            }
        return found;
    }
}
