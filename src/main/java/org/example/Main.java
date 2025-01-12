package org.example;

import Interfaces.IProfessorDAO;
import Interfaces.IStudentDAO;
import Models.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String STUDENTS_FILE = "C:/Users/Tudor/Desktop/MIP/ProiectPirauTudorIoanMaven/students.json";

    public static void main(String[] args) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {

            IStudentDAO studentDAO = new StudentDAO();
            IProfessorDAO professorDAO = new ProfessorDAO();

            int option = 0;
            while (option != 10) {
                System.out.println("=====================================");
                System.out.println("Select an option:");
                System.out.println("1. Display all students");
                System.out.println("2. Add a new student");
                System.out.println("3. Delete a student by ID");
                System.out.println("4. Display all available classes");
                System.out.println("5. Display grades for a student in a class");
                System.out.println("6. Add a grade for a student");
                System.out.println("7. Display all grades of a student in all classes");
                System.out.println("8. Delete a grade for a student");
                System.out.println("9. Display all professors");
                System.out.println("10. Exit");
                System.out.println("=====================================");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        List<Student> students = studentDAO.getAllStudents();
                        System.out.println("All students in the database:");
                        for (Student student : students) {
                            System.out.println(student.getId() + ": " + student.getFirst_name() + " " + student.getLast_name() + ", " + student.getAge() + " years old, " + student.getEmail());
                        }
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        int newStudentId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter first name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter gender: ");
                        String gender = scanner.nextLine();

                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter phone number: ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();

                        System.out.print("Enter faculty: ");
                        String faculty = scanner.nextLine();

                        System.out.print("Enter major: ");
                        String major = scanner.nextLine();

                        System.out.print("Is the student active (true/false): ");
                        boolean isActive = scanner.nextBoolean();
                        scanner.nextLine();

                        Student newStudent = new Student(newStudentId, firstName, lastName, age, gender, email, phoneNumber, address, faculty, major, isActive);
                        studentDAO.addStudent(newStudent);
                        System.out.println("Added new student: " + newStudent.getFirst_name() + " " + newStudent.getLast_name());
                        DataExporter.exportDataToJson(STUDENTS_FILE);
                        break;
                    case 3:
                        System.out.print("Enter student ID to delete: ");
                        int studentIdToDelete = scanner.nextInt();
                        studentDAO.deleteStudent(studentIdToDelete);
                        DataExporter.exportDataToJson(STUDENTS_FILE);
                        break;
                    case 4:
                        List<String> classesList = studentDAO.getAllClasses();
                        System.out.println("All available classes:");
                        for (String className : classesList) {
                            System.out.println(className);
                        }
                        break;
                    case 5:
                        System.out.print("Enter student ID: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter class name: ");
                        String className = scanner.nextLine();
                        List<Double> grades = studentDAO.getStudentGrades(studentId, className);
                        System.out.println("Grades for student ID " + studentId + " in class " + className + ":");
                        for (double grade : grades) {
                            System.out.println(grade);
                        }
                        break;
                    case 6:
                        System.out.print("Enter student ID: ");
                        int studentIdForGrade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter class name: ");
                        String classNameForGrade = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        float grade = scanner.nextFloat();
                        scanner.nextLine();
                        studentDAO.addGrade(studentIdForGrade, classNameForGrade, grade);
                        System.out.println("Added grade " + grade + " for class " + classNameForGrade + " to student ID " + studentIdForGrade);
                        break;
                    case 7:
                        System.out.print("Enter student ID: ");
                        int studentIdForAllGrades = scanner.nextInt();
                        scanner.nextLine();
                        List<ClassInfo> classes = studentDAO.getAllGrades(studentIdForAllGrades);
                        System.out.println("Grades for student ID " + studentIdForAllGrades + " in all classes:");
                        for (ClassInfo classInfo : classes) {
                            System.out.println("Class: " + classInfo.getClassName());
                            for (float grade2 : classInfo.getGrades()) {
                                System.out.println("Grade: " + grade2);
                            }
                        }
                        break;
                    case 8:
                        System.out.print("Enter student ID: ");
                        int studentIdForDeleteGrade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter class name: ");
                        String classNameForDeleteGrade = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        float gradeToDelete = scanner.nextFloat();
                        scanner.nextLine();
                        studentDAO.deleteGrade(studentIdForDeleteGrade, classNameForDeleteGrade, gradeToDelete);
                        System.out.println("Deleted grade " + gradeToDelete + " for class " + classNameForDeleteGrade + " from student ID " + studentIdForDeleteGrade);
                        break;
                    case 9:
                        List<Professor> professors = professorDAO.getAllProfessors();
                        System.out.println("All professors in the database:");
                        for (Professor professor : professors) {
                            System.out.println("Professor ID: " + professor.getId());
                            System.out.println("Name: " + professor.getFirstName() + " " + professor.getLastName());
                            System.out.println("Faculty: " + professor.getFaculty());
                            System.out.println("Class Name: " + professor.getClassName());
                            System.out.println();
                        }
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}