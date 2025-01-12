package Models;

import Interfaces.IStudentDAO;
import org.example.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private Connection connection;

    public StudentDAO() {
        this.connection = DatabaseUtil.getConnection();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (id, first_name, last_name, age, gender, email, phone, address, faculty, major, psycho_pedagogical_module) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getFirst_name());
            stmt.setString(3, student.getLast_name());
            stmt.setInt(4, student.getAge());
            stmt.setString(5, student.getGender());
            stmt.setString(6, student.getEmail());
            stmt.setString(7, student.getPhone());
            stmt.setString(8, student.getAddress());
            stmt.setString(9, student.getFaculty());
            stmt.setString(10, student.getMajor());
            stmt.setBoolean(11, student.isPsycho_pedagogical_module());
            stmt.executeUpdate();
        }
    }

    @Override
    public Student getStudent(int id) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("faculty"),
                        rs.getString("major"),
                        rs.getBoolean("psycho_pedagogical_module")
                );
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("faculty"),
                        rs.getString("major"),
                        rs.getBoolean("psycho_pedagogical_module")
                ));
            }
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET first_name = ?, last_name = ?, age = ?, gender = ?, email = ?, phone = ?, address = ?, faculty = ?, major = ?, psycho_pedagogical_module = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getFirst_name());
            stmt.setString(2, student.getLast_name());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getGender());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getPhone());
            stmt.setString(7, student.getAddress());
            stmt.setString(8, student.getFaculty());
            stmt.setString(9, student.getMajor());
            stmt.setBoolean(10, student.isPsycho_pedagogical_module());
            stmt.setInt(11, student.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Deleted student with ID: " + id);
        }
    }

    @Override
    public List<Double> getStudentGrades(int studentId, String className) throws SQLException {
        List<Double> grades = new ArrayList<>();
        String query = "SELECT grade FROM classes WHERE student_id = ? AND class_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, className);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                grades.add(Double.parseDouble(rs.getString("grade")));
            }
        }
        return grades;
    }

    @Override
    public void addGrade(int studentId, String className, float grade) throws SQLException {
        String query = "INSERT INTO classes (student_id, class_name, grade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, className);
            stmt.setFloat(3, grade);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<ClassInfo> getAllGrades(int studentId) throws SQLException {
        List<ClassInfo> classes = new ArrayList<>();
        String query = "SELECT class_name, grade FROM classes WHERE student_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String className = rs.getString("class_name");
                float grade = rs.getFloat("grade");
                ClassInfo classInfo = findClassInfo(classes, className);
                if (classInfo == null) {
                    classInfo = new ClassInfo(className);
                    classes.add(classInfo);
                }
                classInfo.addGrade(grade);
            }
        }
        return classes;
    }

    private ClassInfo findClassInfo(List<ClassInfo> classes, String className) {
        for (ClassInfo classInfo : classes) {
            if (classInfo.getClassName().equals(className)) {
                return classInfo;
            }
        }
        return null;
    }

    public List<String> getAllClasses() throws SQLException {
        List<String> classes = new ArrayList<>();
        String query = "SELECT DISTINCT class_name FROM classes";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                classes.add(rs.getString("class_name"));
            }
        }
        return classes;
    }

    @Override
    public void deleteGrade(int studentId, String className, float grade) throws SQLException {
        String query = "DELETE FROM classes WHERE student_id = ? AND class_name = ? AND grade = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, className);
            stmt.setFloat(3, grade);
            stmt.executeUpdate();
        }
    }
}