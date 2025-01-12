package Models;

import Interfaces.IClassInfo;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo implements IClassInfo {
    private String className;
    private List<Float> grades;

    public ClassInfo(String className) {
        this.className = className;
        this.grades = new ArrayList<>();
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public List<Float> getGrades() {
        return grades;
    }

    @Override
    public void addGrade(float grade) {
        grades.add(grade);
    }

    @Override
    public float calculateAverageGrade() {
        float sum = 0;
        for (float grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }
}