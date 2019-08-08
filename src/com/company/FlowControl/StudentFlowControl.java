package com.company.FlowControl;

import com.company.Data;
import com.company.users.Course;
import com.company.users.Doctor;
import com.company.users.Student;
import com.company.users.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentFlowControl {
    private static final Scanner scanner = new Scanner(System.in);

    protected static void student(User user) throws InputMismatchException {
        Student student = new Student(user);
        System.out.println("please make a choice: ");
        System.out.println("1 - register in course" + "\n" +
                "2 - list my course" + "\n" +
                "3 - log out");
        int choice = 0;
        do
            choice = scanner.nextInt();
        while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                Course course = FlowControl.getSelectedCourse(listAllCourse(student));
                if (course != null)
                    student.registerToCourse(course);

                student(student);
                break;
            case 2:
                course = FlowControl.getSelectedCourse(student.getAllCourses());
                if (course != null)
                    student.viewCourse(course);

                student(student);
                break;

            case 3:
                FlowControl.login();
        }

    }
    @Contract("_ -> null")
    private static List<Course> listAllCourse(@NotNull Student student) {
        List<Course> courses = student.getAllCourses();
        List<Course> c0 = new ArrayList<>();
        for (Doctor doctor : Data.DOCTORS) {
            for (Course course : doctor.getAllCourses()) {
                boolean b = true;
                for (Course c : courses) {
                    if (c.equals(course)) {
                        b = false;
                        break;
                    }
                }
                if (b) c0.add(course);


            }
        }


        return c0;
    }
}
