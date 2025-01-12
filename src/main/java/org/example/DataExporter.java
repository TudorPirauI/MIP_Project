package org.example;

import Models.Student;
import Models.StudentDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DataExporter {

    public static void exportDataToJson(String filePath) throws SQLException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAllStudents();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File(filePath), students);
    }

    public static void main(String[] args) {
        try {
            exportDataToJson("students.json");
            System.out.println("Data exported to students.json");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}