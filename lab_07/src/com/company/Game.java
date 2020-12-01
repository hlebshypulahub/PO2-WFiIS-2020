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
    private double p;
    private final char hero = '•';
    private final char brick = '█';

    Game(int nx, int ny, double p) {
        this.nx = nx;
        this.ny = ny;
        xWin = nx / 2;
        yWin = 0;
        this.p = p;
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

    public void setP(double p) {
        this.p = p;
    }

    public void buildBoard() {
        board = new char[ny][nx];

        for (char[] row : board)
            Arrays.fill(row, brick);

        board[yWin][xWin] = ' ';

        boolean done = false;
        for (int i = 1; i < ny - 1; i++)
            for (int j = 1; j < nx - 1; j++) {
                Random random = new Random();
                double r = random.nextDouble();
                if (r > getP())
                    board[i][j] = ' ';
                if (i == ny - 2 && board[i][j] == ' ' && !done) {
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

    public void step(Direction dir, CheckStep check) {
        if (check.test(board, x0, y0, dir)) {
            int x1 = getX0() + dir.getX();
            int y1 = getY0() + dir.getY();
            move(x1, y1);
            setX0(x1);
            setY0(y1);
            if (x0 == xWin && y0 == yWin) {
                System.out.println("GRATULACJE, WYGRALES!\nSproboj ponownie ('q' aby wyjsc)\n");
                buildBoard();
            }
        } else {
            System.out.println("NIE UDALO SIE WYKONAC TAKIEGO RUCHU.\n");
        }
    }

    public void move(int x1, int y1) {
        board[y0][x0] = ' ';
        board[y1][x1] = '•';
    }

    public boolean hasHero() {
        boolean found = false;
        for (int i = ny - 2; i >= 0; i--)
            for (int j = nx - 2; j >= 1; j--) {
                if (board[i][j] == hero && !found) {
                    found = true;
                    break;
                }
            }
        return found;
    }
}
