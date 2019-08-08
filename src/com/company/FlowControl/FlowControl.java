package com.company.FlowControl;

import com.company.users.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlowControl {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() throws InputMismatchException {
        System.out.println("Please make a choice:\n1 - Login\n2 - SignUp\n3 - Shutdown System");
        int choice = 0;
        do {
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                break;
            case 3:
                return;
        }
    }

    protected static void login() throws InputMismatchException {
        System.out.println("login as\n1 - doctor\n2 - student\n3 - back");
        int choice = 0;
        do {
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 3);
        switch (choice) {
            case 1:
                User doctor = userLogin(new Doctor());
                while (doctor == null) {
                    System.out.printf("something incorrect please try again");
                    doctor = userLogin(new Doctor());
                }
                DoctorFlowControl.doctor(doctor);
                break;
            case 2:
                User student = userLogin(new Student());
                while (student == null) {
                    System.out.println("something incorrect please try again");
                    student = userLogin(new Student());
                }
                StudentFlowControl.student(student);
                break;
            case 3:
                menu();

        }

    }

    private static User userLogin(@NotNull User user) {
        String username, password;
        System.out.print("username : ");
        username = scanner.next();
        System.out.print("\npassword : ");
        password = scanner.next();
        return user.login(username, password);
    }

    private static void signUp() throws InputMismatchException {
        System.out.println("sign up  as\n1 - doctor\n2 - student\n3 - back");
        int choice = 0;

        do
            choice = scanner.nextInt();
        while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                Doctor doctor = new Doctor();
                userSignUp(doctor);
                DoctorFlowControl.doctor(doctor);
                break;
            case 2:
                Student student = new Student();
                userSignUp(student);
                StudentFlowControl.student(student);
                break;
            case 3:
                menu();
        }
    }

    private static void userSignUp(@NotNull User user) throws InputMismatchException {
        String fname, mname, lname, email, password, username;
        int age;

        System.out.print("first name : ");
        fname = scanner.next();
        System.out.print("\nmiddle name : ");
        mname = scanner.next();
        System.out.print("\nlast name : ");
        lname = scanner.next();
        System.out.print("\nemail : ");
        email = scanner.next();
        System.out.print("\npassword : ");
        password = scanner.next();
        System.out.print("\nusername : ");
        username = scanner.next();
        System.out.print("\nage : ");
        age = scanner.nextInt();

        user.setName(new Name(fname, mname, lname));
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setAge(age);
        user.signUp();
    }

    @Nullable
    protected static Course getSelectedCourse(@NotNull List<Course> courses) throws InputMismatchException {
        if (courses == null || courses.size() == 0) {
            System.out.println("empty list");
            return null;
        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + " " + courses.get(i).getId() + " " + courses.get(i).getName());
        }
        int choice = 0;
        do
            choice = scanner.nextInt();
        while (choice < 1 || choice > courses.size());
        return courses.get(choice - 1);
    }
}
