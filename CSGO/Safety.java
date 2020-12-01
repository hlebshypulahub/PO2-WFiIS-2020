package com.company;

public class Safety extends Terrorist {

    private Terrorist ter_;
    private boolean state;

    Safety(Terrorist ter)
    {
        ter_ = new Terrorist1(ter.name_);
        state = true;
    }

    void applySafetyMeasures()
    {
        state = false;
    }

    void what()
    {
        ter_.what();
    }

    void attack()
    {
        if(state)
            ter_.attack();
    }

}
