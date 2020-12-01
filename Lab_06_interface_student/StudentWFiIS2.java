package com.company;

public class StudentWFiIS2 implements StudentUSOS {
    private final String[] przedmioty;
    private final int rok;
    private final Student stud;

    /* IMPLEMETACJA METOD: */
    public StudentWFiIS2(String n, String s, int id, int rok,
                         String p1, double o1, String p2, double o2, String p3, double o3) {
        stud = new Student(n, s, id, o1, o2, o3);
        this.rok = rok;
        przedmioty = new String[]{p1, p2, p3};
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + stud.toString();
    }

    @Override
    public double srednia() {
        return stud.average();
    }

    @Override
    public void listaPrzedmiotow() {
        for (int i = 0; i < przedmioty.length; ++i)
            System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + stud.getGrade(i));
    }
}
