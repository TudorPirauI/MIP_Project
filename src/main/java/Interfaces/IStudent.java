package Interfaces;

import Models.ClassInfo;
import java.util.List;

public interface IStudent {
    int getId();
    void setId(int id);
    String getFirst_name();
    void setFirst_name(String first_name);
    String getLast_name();
    void setLast_name(String last_name);
    int getAge();
    void setAge(int age);
    String getGender();
    void setGender(String gender);
    String getEmail();
    void setEmail(String email);
    String getPhone();
    void setPhone(String phone);
    String getAddress();
    void setAddress(String address);
    String getFaculty();
    void setFaculty(String faculty);
    String getMajor();
    void setMajor(String major);
    boolean isPsycho_pedagogical_module();
    void setPsycho_pedagogical_module(boolean psycho_pedagogical_module);
    List<ClassInfo> getClasses();
    void addClass(ClassInfo classInfo);
    ClassInfo getClassInfo(String className);
}