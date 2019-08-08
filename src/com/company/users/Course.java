package com.company.users;

import org.jetbrains.annotations.Contract;


public class Course {
   private String id;
   private String name;
   private int number;

    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    @Contract(pure = true)
    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Contract(pure = true)
    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
