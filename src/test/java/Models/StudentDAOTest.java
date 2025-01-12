package Models;

import org.example.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private static Connection connection;
    private StudentDAO studentDAO;

    @BeforeAll
    static void setupDatabase() {
        connection = DatabaseUtil.getConnection();
    }

    @BeforeEach
    void setup() {
        studentDAO = new StudentDAO();
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.createStatement().execute("DELETE FROM students");
        connection.createStatement().execute("DELETE FROM classes");
    }

    @Test
    void testAddStudent() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        Student retrievedStudent = studentDAO.getStudent(1);
        assertNotNull(retrievedStudent);
        assertEquals("Mihai", retrievedStudent.getFirst_name());
    }

    @Test
    void testGetStudent() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        Student retrievedStudent = studentDAO.getStudent(1);
        assertNotNull(retrievedStudent);
        assertEquals("Mihai", retrievedStudent.getFirst_name());
    }

    @Test
    void testGetAllStudents() throws SQLException {
        Student student1 = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        Student student2 = new Student(2, "Jane", "Smith", 22, "FeMasculin", "jane.smith@gmail.com", "0987654321", "456 Main St", "Science", "Biology", false);
        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);
        List<Student> students = studentDAO.getAllStudents();
        assertEquals(2, students.size());
    }

    @Test
    void testUpdateStudent() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        student.setFirst_name("Mihainy");
        studentDAO.updateStudent(student);
        Student updatedStudent = studentDAO.getStudent(1);
        assertEquals("Mihainy", updatedStudent.getFirst_name());
    }

    @Test
    void testDeleteStudent() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        studentDAO.deleteStudent(1);
        Student deletedStudent = studentDAO.getStudent(1);
        assertNull(deletedStudent);
    }

    @Test
    void testGetStudentGrades() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        studentDAO.addGrade(1, "Math", 95.0f);
        List<Double> grades = studentDAO.getStudentGrades(1, "Math");
        assertEquals(1, grades.size());
        assertEquals(95.0, grades.get(0));
    }

    @Test
    void testAddGrade() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        studentDAO.addGrade(1, "Math", 95.0f);
        List<Double> grades = studentDAO.getStudentGrades(1, "Math");
        assertTrue(grades.contains(95.0));
    }

    @Test
    void testGetAllGrades() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        studentDAO.addGrade(1, "Math", 95.0f);
        studentDAO.addGrade(1, "Science", 85.0f);
        List<ClassInfo> classes = studentDAO.getAllGrades(1);
        assertEquals(2, classes.size());
    }

    @Test
    void testDeleteGrade() throws SQLException {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "0722222222", "Lunga 123", "Matematica", "Informatica", true);
        studentDAO.addStudent(student);
        studentDAO.addGrade(1, "Math", 95.0f);
        studentDAO.deleteGrade(1, "Math", 95.0f);
        List<Double> grades = studentDAO.getStudentGrades(1, "Math");
        assertFalse(grades.contains(95.0));
    }
}