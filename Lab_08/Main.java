package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nx = 0;
        int ny = 0;
        boolean isNx = false;
        boolean isNy = false;

        while (true) {
            try {
                if (!isNx || nx < 2) {
                    System.out.println("Podaj liczbe calkowita wieksza (nx) od 1:");
                    nx = Integer.parseInt(sc.nextLine());
                    isNx = true;
                }
                if (!isNy || ny < 2) {
                    System.out.println("Podaj liczbe calkowita wieksza (ny) od 1:");
                    ny = Integer.parseInt(sc.nextLine());
                    isNy = true;
                }
                if (nx < 2)
                    throw new ArithmeticException("Zbyt mala wartosc nx: " + nx);
                if (ny < 2)
                    throw new ArithmeticException("Zbyt mala wartosc ny: " + ny);
                break;
            } catch (NumberFormatException e) {
                System.out.println("BLAD: Podaj liczbe calkowita!\n");
            } catch (ArithmeticException e) {
                System.out.println("BLAD: " + e.getMessage() + "\n");
            }
        }

        System.out.println();

        Game game = new Game(nx, ny);
        game.buildBoard();
        System.out.println(game);

        char c;

        while (true) {
            System.out.print("Wybierz opcje: ");
            c = sc.next().charAt(0);

            try {
                switch (c) {
                    case '0':
                        game.buildBoard();
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                    case 'a':
                        game.step(Direction.valueOf("LEFT"));
                        break;
                    case 'd':
                        game.step(Direction.valueOf("RIGHT"));
                        break;
                    case 's':
                        game.step(Direction.valueOf("DOWN"));
                        break;
                    case 'w':
                        game.step(Direction.valueOf("UP"));
                        break;
                    default:
                        throw new OptionNotRecognizedException("Niepoprawna opcja: ", c);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (WallException e) {
                System.out.println(e.getMessage() + e.getPosition());
            } catch (OptionNotRecognizedException e) {
                System.out.println(e.getMessage() + e.getC());
            }

            System.out.println(game);

        }
    }
}
