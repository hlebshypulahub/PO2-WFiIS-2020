package com.company;

public enum Option {
    RESET('0', "Reset planszy", null),
    LEFT('a', "Przesun w lewo", Direction.valueOf("LEFT")),
    RIGHT('d', "Przesun w prawo", Direction.valueOf("RIGHT")),
    UP('w', "Przesun w gore", Direction.valueOf("UP")),
    DOWN('s', "Przesun w dol", Direction.valueOf("DOWN")),
    EXIT('q', "Zakonczenie gry", null),
    INC('q', "Zwieksz trudnosc", null),
    REDUCE('-', "Zmniejsz trudnosc", null);

    private final char c;
    private final String opis;
    private final Direction dir;

    Option(char c, String opis, Direction dir) {
        this.c = c;
        this.opis = opis;
        this.dir = dir;
    }

    public final char getC() {
        return c;
    }

    public final String getOpis() {
        return opis;
    }

    public final Direction getDir() {
        return dir;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getDir() == null) {
            sb.append("'").append(Character.valueOf(getC()).toString())
              .append("' ==> ").append("opcja ").append(this.name())
              .append(", opis: ").append(getOpis());
        } else
            sb.append("'").append(Character.valueOf(getC()).toString())
              .append("' ==> ").append("opcja ").append(getDir().name())
              .append(", opis: ").append(getOpis()).append(", wektor przesuniecia: ")
              .append(getDir().toString());
        return sb.toString();
    }

    public static void printOptions() {
        System.out.println("Dostepne opcje:");
        System.out.println(Option.valueOf("LEFT"));
        System.out.println(Option.valueOf("RIGHT"));
        System.out.println(Option.valueOf("UP"));
        System.out.println(Option.valueOf("DOWN"));
        System.out.println(Option.valueOf("REDUCE"));
        System.out.println(Option.valueOf("INC"));
        System.out.println(Option.valueOf("RESET"));
        System.out.println(Option.valueOf("EXIT"));
        System.out.println();
    }
}
