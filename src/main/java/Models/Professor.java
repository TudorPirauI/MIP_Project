package Models;

import Interfaces.IProfessor;

public class Professor extends Person implements IProfessor {
    private String faculty;
    private String className;

    public Professor() {
        super(0, "", "");
        this.faculty = "";
        this.className = "";
    }

    public Professor(int id, String firstName, String lastName, String faculty, String className) {
        super(id, firstName, lastName);
        this.faculty = faculty;
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println("Professor ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Faculty: " + faculty);
        System.out.println("Class Name: " + className);
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
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
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
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }
}