package com.company;

public class StudentWFiIS3 extends Student {
    private final StudentUSOS stud;

    /* IMPLEMETACJA METOD: */
    public StudentWFiIS3(String n, String s, int id, int rok,
                         String p1, double o1, String p2, double o2, String p3, double o3) {
        super(n, s, id, o1, o2, o3);
        stud = new StudentUSOS() {

            public String toString() {
                return "[" + rok + "] ";
            }

            public double srednia() {
                return average();
            }

            public void listaPrzedmiotow() {
                String[] przedmioty = new String[]{p1, p2, p3};
                for (int i = 0; i < przedmioty.length; ++i)
                    System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + getGrade(i));
            }
        };

    }

    @Override
    public String toString() {
        return stud.toString() + super.toString();
    }

    public double srednia() {
        return stud.srednia();
    }

    public void listaPrzedmiotow() {
        stud.listaPrzedmiotow();
    }

}

