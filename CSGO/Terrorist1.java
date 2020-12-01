package com.company;

import java.util.LinkedList;

public class Terrorist1 extends Terrorist {

    Terrorist1(String name)
    {
        super(name);
    }

    void what()
    {
        LinkedList<String> weapons = new LinkedList<>();
        weapons.add("Knife");
        print(weapons);
    }

    void attack()
    {
        Knife.cut();
    }

}
