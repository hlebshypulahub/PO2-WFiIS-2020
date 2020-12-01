package com.company;

import java.util.LinkedList;

public abstract class Terrorist {

    abstract void what();

    abstract void attack();

    Terrorist(String name)
    {
        name_ = name;
    }

    Terrorist()
    {

    }

    void print(LinkedList<String> weapons)
    {
        System.out.print("This is " + name_ + " carrying: ");

        for(String s : weapons)
        {
            System.out.print(s);
        }

        System.out.println("");
    }

    protected String name_;

}
