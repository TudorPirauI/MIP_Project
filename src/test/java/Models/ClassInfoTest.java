package Models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassInfoTest {

    @Test
    public void testGetClassName() {
        ClassInfo classInfo = new ClassInfo("Matematica");
        assertEquals("Matematica", classInfo.getClassName());
    }

    @Test
    public void testSetClassName() {
        ClassInfo classInfo = new ClassInfo("Matematica");
        classInfo.setClassName("Science");
        assertEquals("Science", classInfo.getClassName());
    }

    @Test
    public void testGetGrades() {
        ClassInfo classInfo = new ClassInfo("Matematica");
        List<Float> grades = classInfo.getGrades();
        assertNotNull(grades);
    }

    @Test
    public void testAddGrade() {
        ClassInfo classInfo = new ClassInfo("Matematica");
        classInfo.addGrade(95.0f);
        List<Float> grades = classInfo.getGrades();
        assertTrue(grades.contains(95.0f));
    }

    @Test
    public void testCalculateAverageGrade() {
        ClassInfo classInfo = new ClassInfo("Matematica");
        classInfo.addGrade(90.0f);
        classInfo.addGrade(80.0f);
        assertEquals(85.0f, classInfo.calculateAverageGrade());
    }
}