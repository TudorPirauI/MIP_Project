package Models;

import Interfaces.IStudent;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements IStudent {
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String faculty;
    private String major;
    private boolean psycho_pedagogical_module;
    private List<ClassInfo> classes;

    public Student() {
        super(0, "", "");
        this.age = 0;
        this.gender = "";
        this.email = "";
        this.phone = "";
        this.address = "";
        this.faculty = "";
        this.major = "";
        this.psycho_pedagogical_module = false;
        this.classes = new ArrayList<>();
    }

    public Student(int id, String firstName, String lastName, int age, String gender, String email,
                   String phone, String address, String faculty, String major, boolean psycho_pedagogical_module) {
        super(id, firstName, lastName);
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.faculty = faculty;
        this.major = major;
        this.psycho_pedagogical_module = psycho_pedagogical_module;
        this.classes = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Faculty: " + faculty);
        System.out.println("Major: " + major);
        System.out.println("Psycho-Pedagogical Module: " + psycho_pedagogical_module);
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getFirst_name() {
        return super.getFirstName();
    }

    @Override
    public void setFirst_name(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLast_name() {
        return super.getLastName();
    }

    @Override
    public void setLast_name(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getFaculty() {
        return faculty;
    }

    @Override
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String getMajor() {
        return major;
    }

    @Override
    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean isPsycho_pedagogical_module() {
        return psycho_pedagogical_module;
    }

    @Override
    public void setPsycho_pedagogical_module(boolean psycho_pedagogical_module) {
        this.psycho_pedagogical_module = psycho_pedagogical_module;
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


