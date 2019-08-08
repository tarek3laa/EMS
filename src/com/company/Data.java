package com.company;

import com.company.users.Doctor;
import com.company.users.Student;
import com.company.users.User;
import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static  List<Student> STUDENTS = new ArrayList<>();
    public static  List<Doctor> DOCTORS = new ArrayList<>();
    @Contract(pure = true)
    private Data(){

    }

}
