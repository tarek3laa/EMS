package com.company;


import com.company.FlowControl.FlowControl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Files files = new StoringData();
        StoringData storingData =
                new Gson().fromJson(files.readFromFile("data"), StoringData.class);

        if (storingData == null)
            storingData = new StoringData(new ArrayList<>(), new ArrayList<>());
        Data.STUDENTS = storingData.getStudents();
        Data.DOCTORS = storingData.getDoctors();
        try {
            FlowControl.menu();
        } catch (InputMismatchException e) {
            System.out.println("\nsomething wrong\n"+e.getMessage());
        } finally {
            storingData.setDoctors(Data.DOCTORS);
            storingData.setStudents(Data.STUDENTS);
            storingData.shutDownSystem();
        }
    }
}
