package com.company.users;

import com.company.Data;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Student extends User {

    public Student(Name name, String email, String password, String username, int age) {
        super(name, email, password, username, age);
    }

    public Student() {
    }

    public Student(@NotNull User user) {
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setAge(user.getAge());
        this.setEmail(user.getEmail());
        this.courses = user.courses;
    }


    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }

    public void registerToCourse(@NotNull Course course) {
        course.setNumber(course.getNumber() + 1);
        this.courses.add(course);

    }

    @Override
    public void viewCourse(@NotNull Course course) {
        System.out.println("\n" + course.getId() + " " + course.getName());
    }


    @Override
    public void signUp() {
        Data.STUDENTS.add(this);

    }

    @Override
    public User login(String username, String password) {
        for (int i = 0; i < Data.STUDENTS.size(); i++) {
            if (Data.STUDENTS.get(i).getUsername().equals(username) && Data.STUDENTS.get(i).getPassword().equals(password))
                return Data.STUDENTS.get(i);
        }
        return null;
    }


}
