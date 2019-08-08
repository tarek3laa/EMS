package com.company.users;

import com.company.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Doctor extends User {
    public Doctor(Name name, String email, String password, String username, int age) {
        super(name, email, password, username, age);
    }

    public Doctor() {
    }

    public Doctor(String password, String username) {
        super(password, username);
    }

    public Doctor(@NotNull User user) {
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

    @Override
    public void viewCourse(@NotNull Course course) {
        System.out.println("\n" + course.getId() + " " + course.getName() + " " + course.getNumber() + " student");
    }

    @Override
    public void signUp() {
        Data.DOCTORS.add(this);
    }

    @Override
    public User login(String username, String password) {
        for (int i = 0; i < Data.DOCTORS.size(); i++) {
            if (Data.DOCTORS.get(i).getUsername().equals(username) && Data.DOCTORS.get(i).getPassword().equals(password))
                return Data.DOCTORS.get(i);
        }
        return null;
    }

    public void crateCourse(Course course) {
        this.courses.add(course);
    }

}
