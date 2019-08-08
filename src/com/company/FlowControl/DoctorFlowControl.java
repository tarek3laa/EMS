package com.company.FlowControl;

import com.company.users.Course;
import com.company.users.Doctor;
import com.company.users.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DoctorFlowControl {
    private static final Scanner scanner = new Scanner(System.in);

    public static void doctor(User user) throws InputMismatchException {
        Doctor doctor = new Doctor(user);
        int choice = 0;
        System.out.println("please make a choice: ");
        System.out.println("1 - create course" + "\n" +
                "2 - list my course" + "\n" +
                "3 - log out");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createCourse(doctor);
                doctor(doctor);
                break;
            case 2:
                Course course = FlowControl.getSelectedCourse(doctor.getAllCourses());
                if (course != null)
                    doctor.viewCourse(course);
                doctor(doctor);
                break;
            case 3:
                FlowControl.login();
        }


    }

    private static void createCourse(@NotNull Doctor doctor) {
        System.out.print("course name : ");
        String name = scanner.next();
        System.out.println("\ncourse Id : ");
        String id = scanner.next();
        doctor.crateCourse(new Course(id, name));

    }


}
