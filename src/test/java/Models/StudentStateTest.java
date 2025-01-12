package Models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentStateTest {

    @Test
    public void testGetClasses() {
        StudentState studentState = new StudentState(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@example.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        List<ClassInfo> classes = studentState.getClasses();
        assertNotNull(classes);
    }

    @Test
    public void testAddClass() {
        StudentState studentState = new StudentState(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@example.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        ClassInfo classInfo = new ClassInfo("Math");
        studentState.addClass(classInfo);
        List<ClassInfo> classes = studentState.getClasses();
        assertTrue(classes.contains(classInfo));
    }

    @Test
    public void testGetClassInfo() {
        StudentState studentState = new StudentState(1, "Mihai", "Dorin", 20, "Masculin", "Mihai.Dorin@example.com", "1234567890", "Lunga 123", "Matematica", "Informatica", true);
        ClassInfo classInfo = new ClassInfo("Chimie");
        studentState.addClass(classInfo);
        ClassInfo retrievedClassInfo = studentState.getClassInfo("Chimie");
        assertNotNull(retrievedClassInfo);
        assertEquals("Chimie", retrievedClassInfo.getClassName());
    }
}