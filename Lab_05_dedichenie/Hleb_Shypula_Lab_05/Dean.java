package com.company;

/**
 * Klasa implementująca dziekana, dziedziczy po Man
 *
 * @author Hleb Shypula
 */
public class Dean extends Man {

    /**
     * Przechowuje stopień naukowy
     */
    private final String stopien;
    /**
     * Przechowuje roku rozpoczęcia kadencji
     */
    private final int begin;
    /**
     * Przechowuje roku zakończenia kadencji
     */
    private final int end;

    /**
     *
     * @param Stopien stopień naukowy
     * @param Name imię
     * @param Surname nazwisko
     * @param Begin początek kadencji
     * @param End koniec kadencji
     */
    public Dean(String Stopien, String Name, String Surname, int Begin, int End) {
        super(Name, Surname);
        begin = Begin;
        end = End;
        stopien = Stopien;
    }

    /**
     * Zwraca referencję na begin
     * @return begin
     */
    public int getBegin() {
        return begin;
    }

    /**
     * Zwraca referencję na end
     * @return end
     */
    public int getEnd() {
        return end;
    }

    /**
     * Zwraca referencję na stopien
     * @return stopien
     */
    public String getStopien() {
        return stopien;
    }

    /**
     * Zwraca obiekt jako String
     * @return String
     */
    public String toString() {
        return getStopien() + " " + super.toString() + " Dean of the Faculty from "
                + getBegin() + " to " + getEnd() + ".";
    }

    /**
     * Zwraca referencję na średnią
     * @return avg
     */
    public double average() {
        System.out.print(" [Average not applicable]");
        return 0.0;
    }

    /**
     * Zwraca dziekana, którego kadencja skończyła/kończy się później
     * @param ob obiekt do porównania
     * @return dean
     */
    public Man compare(Man ob) {
        if (!(ob instanceof Dean)) {
            return null;
        }
        Dean dean = (Dean) ob;
        if (end > dean.getEnd())
            return this;
        return dean;
    }
}
