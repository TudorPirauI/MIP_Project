package Models;

import Interfaces.IStudentState;
import java.util.ArrayList;
import java.util.List;

public class StudentState extends Student implements IStudentState {
    private List<ClassInfo> classes;

    public StudentState(int id, String first_name, String last_name, int age, String gender, String email, String phone, String address, String faculty, String major, boolean psycho_pedagogical_module) {
        super(id, first_name, last_name, age, gender, email, phone, address, faculty, major, psycho_pedagogical_module);
        this.classes = new ArrayList<>();
    }

    @Override
    public List<ClassInfo> getClasses() {
        return classes;
    }

    @Override
    public void addClass(ClassInfo classInfo) {
        classes.add(classInfo);
    }

    @Override
    public ClassInfo getClassInfo(String className) {
        for (ClassInfo classInfo : classes) {
            if (classInfo.getClassName().equals(className)) {
                return classInfo;
            }
        }
        return null;
    }
}