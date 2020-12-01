package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Klasa implementująca studenta, dziedziczy po Man
 *
 * @author Hleb Shypula
 */
public class Student extends Man {

    /**
     * Przechowuje numer albumu
     */
    private final int id;
    /**
     * Przechowuje oceny
     */
    private final ArrayList<Double> oceny;
    /**
     * Przechowuje średnią ocen
     */
    private final double avg;

    /**
     *
     * @param Name imię
     * @param Surname nazwisko
     * @param ID numer albumu
     * @param o1 ocena 1
     * @param o2 ocena 2
     * @param o3 ocena 3
     */
    public Student(String Name, String Surname, int ID, double o1, double o2, double o3) {
        super(Name, Surname);
        id = ID;
        oceny = new ArrayList<>();
        oceny.add(o1);
        oceny.add(o2);
        oceny.add(o3);
        double sum = 0;
        for (double e : getOceny()) {
            sum += e;
        }
        avg = sum / getOceny().size();
    }

    /**
     * Zwraca referencję na id
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Zwraca referencję na oceny
     * @return oceny
     */
    public ArrayList<Double> getOceny() {
        return oceny;
    }

    /**
     * Zwraca obiekt jako String
     * @return String
     */
    public String toString() {
        return super.toString() + "id number: " + getID() + " grades: [" + getOceny().stream().map(Object::toString).collect(Collectors.joining(", ")) + "]";
    }

    /**
     * Zwraca referencję na średnią
     * @return avg
     */
    public double average() {
        return avg;
    }

    /**
     * Zwraca studenta o wyższej średniej
     * @param ob obiekt do porównania
     * @return ob
     */
    public Man compare(Man ob) {
        if (!(ob instanceof Student)) {
            return null;
        }
        if (avg > ob.average())
            return this;
        return ob;
    }

}
