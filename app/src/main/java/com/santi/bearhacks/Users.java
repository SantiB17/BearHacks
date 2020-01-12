package com.santi.bearhacks;

import java.io.Serializable;

public class Users implements Serializable {
    private String name;
    private int hoursWorked;


    public Users () {
        this.name = "Joe Rogan";
        this.hoursWorked = 0;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name += name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
