package Interfaces;

import java.util.List;

public interface IClassInfo {
    String getClassName();

    void setClassName(String className);

    List<Float> getGrades();

    void addGrade(float grade);

    float calculateAverageGrade();
}