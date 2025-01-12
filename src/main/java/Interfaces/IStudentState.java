package Interfaces;

import Models.ClassInfo;

import java.util.List;

public interface IStudentState {

    List<ClassInfo> getClasses();

    void addClass(ClassInfo classInfo);

    ClassInfo getClassInfo(String className);
}