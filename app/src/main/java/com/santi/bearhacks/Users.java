package com.santi.bearhacks;

public class Users {
    private String name;
    private int age;
    private int hoursWorked;

    public Users () {
        this.name = "john";
        this.age = 12;
        this.hoursWorked = 1;
    }

    public Users(String name, int age, int hours) {
        this.name = name;
        this.age = age;
        this.hoursWorked = hours;
        //this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
