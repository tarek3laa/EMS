package com.company;

import com.company.users.Doctor;
import com.company.users.Student;
import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.List;

public class StoringData implements Files {

    private List<Student> students;
    private List<Doctor> doctors;

    @Contract(pure = true)
    public StoringData() {
    }

    public void shutDownSystem() {
        Gson gson = new Gson();
        appendToFile(new File("/home/tarek/IdeaProjects/EMS/src/com/company/" + "data"), gson.toJson(this));
    }

    @Override
    public String readFromFile(@NotNull String filename) {
        File file = new File("/home/tarek/IdeaProjects/EMS/src/com/company/" + filename);
        String lines = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String line;
            do {
                line = br.readLine();
                if (line != null) lines += line;
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return lines;
    }

    @Override
    public void appendToFile(@NotNull File file, String content) {
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Contract(pure = true)
    public StoringData(List<Student> students, List<Doctor> doctors) {
        this.students = students;
        this.doctors = doctors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
