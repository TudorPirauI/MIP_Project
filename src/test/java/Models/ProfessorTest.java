package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProfessorTest {

    @Test
    public void getIdFromProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals(1, professor.getId());
    }

    @Test
    public void checkBugIfProfessorIdIsIncorrectTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals(2, professor.getId());
    }

    @Test
    public void getFirstNameFromProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals("Ion", professor.getFirstName());
    }

    @Test
    public void checkBugIfProfessorFirstNameIsIncorrectTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals("Jane", professor.getFirstName());
    }

    @Test
    public void getLastNameFromProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertEquals("Popescu", professor.getLastName());
    }

    @Test
    public void checkBugIfProfessorLastNameIsIncorrectTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        assertNotEquals("Smith", professor.getLastName());
    }

    @Test
    public void setIdForProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        professor.setId(2);
        assertEquals(2, professor.getId());
    }

    @Test
    public void setFirstNameForProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        professor.setFirstName("Jane");
        assertEquals("Jane", professor.getFirstName());
    }

    @Test
    public void setLastNameForProfessorTest() {
        Professor professor = new Professor(1, "Ion", "Popescu", "Informatica", "Programare") {
            @Override
            public void displayInfo() {
            }
        };
        professor.setLastName("Smith");
        assertEquals("Smith", professor.getLastName());
    }
}