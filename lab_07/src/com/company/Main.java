package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Option.printOptions();

        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj szerokosc labiryntu: ");
        int nx = Integer.parseInt(sc.nextLine());
        System.out.print("Podaj wysokosc labiryntu: ");
        int ny = Integer.parseInt(sc.nextLine());
        System.out.print("Podaj trudnosc [1..10]: ");
        double p = Double.parseDouble(sc.nextLine()) / 20;

        Game game = new Game(nx, ny, p);
        game.buildBoard();
        System.out.println(game);

        char c;

        CheckStep check = (char[][] b, int x0, int y0, Direction dir)
                -> b[y0 + dir.getY()][x0 + dir.getX()] == ' ';

        while (true) {
            System.out.print("Wybierz opcje: ");
            c = sc.next().charAt(0);

            switch (c) {
                case '0':
                    game.buildBoard();
                    break;
                case 'q':
                    System.exit(0);
                    break;
                case 'a':
                    game.step(Direction.valueOf("LEFT"), check);
                    break;
                case 'd':
                    game.step(Direction.valueOf("RIGHT"), check);
                    break;
                case 's':
                    game.step(Direction.valueOf("DOWN"), check);
                    break;
                case 'w':
                    game.step(Direction.valueOf("UP"), check);
                    break;
                case '-':
                    if (p > 1.0 / 20) {
                        p = (p * 20 - 1) / 20;
                        game.setP(p);
                    }
                    game.buildBoard();
                    System.out.println("Aktualna trudnosc: " + (int) (p * 20));
                    break;
                case '+':
                    if (p < 10.0 / 20) {
                        p = (p * 20 + 1) / 20;
                        game.setP(p);
                    }
                    game.buildBoard();
                    System.out.println("Aktualna trudnosc: " + (int) (p * 20));
                    break;
                default:
                    System.out.println("Niepoprawna opcja.");
            }

            System.out.println(game);
        }
    }
}
