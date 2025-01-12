package Models;

import org.example.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfessorDAOTest {

    private static Connection connection;
    private ProfessorDAO professorDAO;

    @BeforeAll
    static void setupDatabase() {
        connection = DatabaseUtil.getConnection();
    }

    @BeforeEach
    void setup() {
        professorDAO = new ProfessorDAO();
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.createStatement().execute("DELETE FROM professor");
    }

    @Test
    void testGetAllProfessors() throws SQLException {
        Professor professor1 = new Professor(1, "Ion", "Popescu", "Informatica", "Programare");
        Professor professor2 = new Professor(2, "Maria", "Ionescu", "Matematica", "Algebra");

        connection.createStatement().execute("INSERT INTO professor (id, first_name, last_name, faculty, class_name) VALUES (1, 'Ion', 'Popescu', 'Informatica', 'Programare')");
        connection.createStatement().execute("INSERT INTO professor (id, first_name, last_name, faculty, class_name) VALUES (2, 'Maria', 'Ionescu', 'Matematica', 'Algebra')");

        List<Professor> professors = professorDAO.getAllProfessors();
        assertEquals(2, professors.size());
    }
}