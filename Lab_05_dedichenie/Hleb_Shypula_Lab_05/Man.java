package com.company;

/**
 * Klasa abstrakcyjna implementująca osobę
 *
 * @author Hleb Shypula
 */
abstract class Man {
    /**
     * Przechowuje imię osoby
     */
    private final String name;
    /**
     * Przechowuje nazwisko osoby
     */
    private final String surname;

    /**
     *
     * @param Name imię
     * @param Surname nazwisko
     */
    public Man(String Name, String Surname) {
        name = Name;
        surname = Surname;
    }

    /**
     * Zwraca referencję na imię
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Zwraca referencję na nazwisko
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Zwraca obiekt jako String
     * @return String
     */
    public String toString() {
        return getName() + " " + getSurname() + ", ";
    }

    /**
     * Metoda abstrakcyjna
     * @param ob obiekt do porównania
     * @return ob
     */
    abstract public Man compare(Man ob);

    /**
     * Zwraca średnią ocenę
     * @return 0.0
     */
    public double average() {
        return 0.0;
    }
}