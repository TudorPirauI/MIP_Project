package Interfaces;

import Models.ClassInfo;
import Models.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    void addStudent(Student student) throws SQLException;

    Student getStudent(int id) throws SQLException;

    List<Student> getAllStudents() throws SQLException;

    void updateStudent(Student student) throws SQLException;

    void deleteStudent(int id) throws SQLException;

    List<Double> getStudentGrades(int studentId, String className) throws SQLException;

    void addGrade(int studentId, String className, float grade) throws SQLException;

    List<ClassInfo> getAllGrades(int studentId) throws SQLException;

    void deleteGrade(int studentId, String className, float grade) throws SQLException;

    List<String> getAllClasses() throws SQLException; // Add this method
}


