package com.company;

public class StudentWFiIS1 extends Student implements StudentUSOS {
    private final String[] przedmioty;
    private final int rok;

    /* IMPLEMETACJA METOD: */
    public StudentWFiIS1(String n, String s, int id, int rok,
                         String p1, double o1, String p2, double o2, String p3, double o3) {
        super(n, s, id, o1, o2, o3);
        this.rok = rok;
        przedmioty = new String[]{p1, p2, p3};
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + super.toString();
    }

    @Override
    public double srednia() {
        return super.average();
    }

    @Override
    public void listaPrzedmiotow() {
        for (int i = 0; i < przedmioty.length; ++i)
            System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + super.getGrade(i));
    }

}
