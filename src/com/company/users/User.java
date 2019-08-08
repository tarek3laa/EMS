package com.company.users;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private Name name;
    private String email, password, username;
    private int age;
    protected List<Course> courses = new ArrayList<>();

    public User(Name name, String email, String password, String username, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.age = age;
    }
    @Deprecated
    public User() {
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract List<Course> getAllCourses();

    public abstract void viewCourse(Course course);

    public abstract void signUp();

    public abstract User login(String username, String password);

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return password.equals(user.password) && username.equals(user.username);
    }

}
