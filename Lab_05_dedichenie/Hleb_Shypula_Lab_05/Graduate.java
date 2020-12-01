package com.company;

/**
 * Klasa implementująca absolwenta, dziedziczy po Student
 *
 * @author Hleb Shypula
 */
public class Graduate extends Student {

    /**
     * Przechowuje rok ukończenia
     */
    private final int rok;
    /**
     * Przechowuje stopien naukowy
     */
    private final String stopien;

    /**
     *
     * @param Stopien stopień naukowy
     * @param Name imię
     * @param Surname nazwisko
     * @param ID numer albumu
     * @param Rok rok ukończenia studiów
     * @param o1 ocena 1
     * @param o2 ocena 2
     * @param o3 ocena 3
     */
    public Graduate(String Stopien, String Name, String Surname, int ID, int Rok, double o1, double o2, double o3) {
        super(Name, Surname, ID, o1, o2, o3);
        rok = Rok;
        stopien = Stopien;
    }

    /**
     * Zwraca referencję na rok
     * @return rok
     */
    public int getRok() {
        return rok;
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
        return getStopien() + " " + super.toString() + ", year of graduation: " + getRok();
    }

}
