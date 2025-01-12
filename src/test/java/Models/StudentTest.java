package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StudentTest {

    @Test
    public void getFirstNameFromStudentTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertEquals("Mihai", student.getFirst_name());
    }

    @Test
    public void checkBugIfStudentFirstNameIsIncorrectTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertNotEquals("Jane", student.getFirst_name());
    }

    @Test
    public void getLastNameFromStudentTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertEquals("Dorin", student.getLast_name());
    }

    @Test
    public void checkBugIfStudentLastNameIsIncorrectTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertNotEquals("Smith", student.getLast_name());
    }

    @Test
    public void getAgeFromStudentTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertEquals(20, student.getAge());
    }

    @Test
    public void checkBugIfStudentAgeIsIncorrectTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertNotEquals(25, student.getAge());
    }

    @Test
    public void getEmailFromStudentTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertEquals("Mihai.Dorin@gmail.com", student.getEmail());
    }

    @Test
    public void checkBugIfStudentEmailIsIncorrectTest() {
        Student student = new Student(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@gmail.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        assertNotEquals("jane.Dorin@gmail.com", student.getEmail());
    }
}