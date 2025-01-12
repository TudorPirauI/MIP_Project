package org.example;

import Interfaces.IProfessorDAO;
import Interfaces.IStudentDAO;
import Models.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainApp extends Application {

    private IStudentDAO studentDAO = new StudentDAO();
    private Stage primaryStage;
    private static final String STUDENTS_FILE = "C:/Users/Tudor/Desktop/MIP/ProiectPirauTudorIoanMaven/students.json";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Student Management System");

        primaryStage.setFullScreenExitHint("");

        try {
            DataExporter.exportDataToJson(STUDENTS_FILE);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Student Management System");
        titleLabel.getStyleClass().add("title-label");

        VBox buttonLayout = new VBox(10);
        buttonLayout.setAlignment(Pos.CENTER);

        Button retrieveButton = new Button("Display all students");
        retrieveButton.setOnAction(e -> retrieveAllStudents());

        Button addButton = new Button("Add a new student");
        addButton.setOnAction(e -> addStudent());

        Button deleteButton = new Button("Delete a student by ID");
        deleteButton.setOnAction(e -> deleteStudent());

        Button displayClassesButton = new Button("Display all available classes");
        displayClassesButton.setOnAction(e -> displayAllClasses());

        Button retrieveGradesButton = new Button("Display grades for a student in a class");
        retrieveGradesButton.setOnAction(e -> retrieveStudentGrades());

        Button addGradeButton = new Button("Add a grade for a student");
        addGradeButton.setOnAction(e -> addGrade());

        Button displayGradesButton = new Button("Display all grades of a student in all classes");
        displayGradesButton.setOnAction(e -> displayAllGrades());

        Button deleteGradeButton = new Button("Delete a grade for a student");
        deleteGradeButton.setOnAction(e -> deleteGrade());

        Button retrieveProfessorsButton = new Button("Display all professors");
        retrieveProfessorsButton.setOnAction(e -> retrieveAllProfessors());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> primaryStage.close());

        buttonLayout.getChildren().addAll(retrieveButton, addButton, deleteButton, displayClassesButton, retrieveGradesButton, addGradeButton, displayGradesButton, deleteGradeButton, retrieveProfessorsButton, exitButton);

        mainLayout.getChildren().addAll(titleLabel, buttonLayout);

        Scene scene = new Scene(mainLayout, 800, 600);
        scene.getStylesheets().add("/style.css");

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void addStudent() {
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Add a New Student");

        addStudentStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Label firstNameLabel = new Label("First Name:");
        GridPane.setConstraints(firstNameLabel, 0, 1);
        TextField firstNameInput = new TextField();
        GridPane.setConstraints(firstNameInput, 1, 1);

        Label lastNameLabel = new Label("Last Name:");
        GridPane.setConstraints(lastNameLabel, 0, 2);
        TextField lastNameInput = new TextField();
        GridPane.setConstraints(lastNameInput, 1, 2);

        Label ageLabel = new Label("Age:");
        GridPane.setConstraints(ageLabel, 0, 3);
        TextField ageInput = new TextField();
        GridPane.setConstraints(ageInput, 1, 3);

        Label genderLabel = new Label("Gender:");
        GridPane.setConstraints(genderLabel, 0, 4);
        TextField genderInput = new TextField();
        GridPane.setConstraints(genderInput, 1, 4);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 5);
        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 5);

        Label phoneLabel = new Label("Phone:");
        GridPane.setConstraints(phoneLabel, 0, 6);
        TextField phoneInput = new TextField();
        GridPane.setConstraints(phoneInput, 1, 6);

        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 7);
        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 7);

        Label facultyLabel = new Label("Faculty:");
        GridPane.setConstraints(facultyLabel, 0, 8);
        TextField facultyInput = new TextField();
        GridPane.setConstraints(facultyInput, 1, 8);

        Label majorLabel = new Label("Major:");
        GridPane.setConstraints(majorLabel, 0, 9);
        TextField majorInput = new TextField();
        GridPane.setConstraints(majorInput, 1, 9);

        Label moduleLabel = new Label("Psycho-pedagogical Module:");
        GridPane.setConstraints(moduleLabel, 0, 10);
        CheckBox moduleInput = new CheckBox();
        GridPane.setConstraints(moduleInput, 1, 10);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 11);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                Student newStudent = new Student(
                        studentId,
                        firstNameInput.getText(),
                        lastNameInput.getText(),
                        Integer.parseInt(ageInput.getText()),
                        genderInput.getText(),
                        emailInput.getText(),
                        phoneInput.getText(),
                        addressInput.getText(),
                        facultyInput.getText(),
                        majorInput.getText(),
                        moduleInput.isSelected()
                );
                studentDAO.addStudent(newStudent);

                DataExporter.exportDataToJson(STUDENTS_FILE);

                addStudentStage.close();
                primaryStage.setFullScreen(true);
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 11);
        backButton.setOnAction(e -> {
            addStudentStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        grid.getChildren().addAll(idLabel, idInput, firstNameLabel, firstNameInput, lastNameLabel, lastNameInput, ageLabel, ageInput, genderLabel, genderInput, emailLabel, emailInput, phoneLabel, phoneInput, addressLabel, addressInput, facultyLabel, facultyInput, majorLabel, majorInput, moduleLabel, moduleInput, submitButton, backButton);

        Scene scene = new Scene(grid, 300, 400);
        scene.getStylesheets().add("/style.css");
        addStudentStage.setScene(scene);
        addStudentStage.setFullScreen(true);
        addStudentStage.show();
    }

    private void deleteStudent() {
        Stage deleteStudentStage = new Stage();
        deleteStudentStage.setTitle("Delete a Student");

        deleteStudentStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 1);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                studentDAO.deleteStudent(studentId);
                DataExporter.exportDataToJson(STUDENTS_FILE);
                deleteStudentStage.close();
                primaryStage.setFullScreen(true);
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 1);
        backButton.setOnAction(e -> {
            deleteStudentStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        grid.getChildren().addAll(idLabel, idInput, submitButton, backButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/style.css");
        deleteStudentStage.setScene(scene);
        deleteStudentStage.setFullScreen(true);
        deleteStudentStage.show();
    }

    private void retrieveAllStudents() {
        Stage retrieveStudentsStage = new Stage();
        retrieveStudentsStage.setTitle("All Students");

        retrieveStudentsStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        try {
            List<Student> students = studentDAO.getAllStudents();
            int row = 0;
            for (Student student : students) {
                Label studentLabel = new Label(student.getId() + ": " + student.getFirst_name() + " " + student.getLast_name() + ", " + student.getAge() + " years old, " + student.getEmail());
                GridPane.setConstraints(studentLabel, 0, row++);
                grid.getChildren().add(studentLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            retrieveStudentsStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, backButton);

        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add("/style.css");
        retrieveStudentsStage.setScene(scene);
        retrieveStudentsStage.setFullScreen(true);
        retrieveStudentsStage.show();
    }

    private void displayAllClasses() {
        Stage displayClassesStage = new Stage();
        displayClassesStage.setTitle("Display All Classes");

        displayClassesStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        try {
            List<String> classes = studentDAO.getAllClasses();
            int row = 0;
            for (String className : classes) {
                Label classLabel = new Label("Class: " + className);
                GridPane.setConstraints(classLabel, 0, row++);
                grid.getChildren().add(classLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            displayClassesStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, backButton);

        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add("/style.css");
        displayClassesStage.setScene(scene);
        displayClassesStage.setFullScreen(true);
        displayClassesStage.show();
    }

    private void retrieveStudentGrades() {
        Stage retrieveGradesStage = new Stage();
        retrieveGradesStage.setTitle("Retrieve Student Grades");

        retrieveGradesStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Label classLabel = new Label("Class Name:");
        GridPane.setConstraints(classLabel, 0, 1);
        TextField classInput = new TextField();
        GridPane.setConstraints(classInput, 1, 1);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 2);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                String className = classInput.getText();
                List<Double> grades = studentDAO.getStudentGrades(studentId, className);

                Stage gradesStage = new Stage();
                gradesStage.setTitle("Grades for Student ID " + studentId + " in Class " + className);

                gradesStage.setFullScreenExitHint("");

                GridPane gradesGrid = new GridPane();
                gradesGrid.setPadding(new Insets(10, 10, 10, 10));
                gradesGrid.setVgap(8);
                gradesGrid.setHgap(10);
                gradesGrid.setAlignment(Pos.CENTER);

                int row = 0;
                for (Double grade : grades) {
                    Label gradeLabel = new Label("Grade: " + grade);
                    GridPane.setConstraints(gradeLabel, 0, row++);
                    gradesGrid.getChildren().add(gradeLabel);
                }

                Button backButton = new Button("Back");
                GridPane.setConstraints(backButton, 0, row);
                backButton.setOnAction(event -> {
                    gradesStage.close();
                    primaryStage.setFullScreen(true);
                    primaryStage.show();
                });
                gradesGrid.getChildren().add(backButton);

                Scene gradesScene = new Scene(gradesGrid, 300, 200);
                gradesScene.getStylesheets().add("/style.css");
                gradesStage.setScene(gradesScene);
                gradesStage.setFullScreen(true);
                gradesStage.show();

                retrieveGradesStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 2);
        backButton.setOnAction(e -> {
            retrieveGradesStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        grid.getChildren().addAll(idLabel, idInput, classLabel, classInput, submitButton, backButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/style.css");
        retrieveGradesStage.setScene(scene);
        retrieveGradesStage.setFullScreen(true);
        retrieveGradesStage.show();
    }

    private void addGrade() {
        Stage addGradeStage = new Stage();
        addGradeStage.setTitle("Add Grade");

        addGradeStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Label classLabel = new Label("Class Name:");
        GridPane.setConstraints(classLabel, 0, 1);
        TextField classInput = new TextField();
        GridPane.setConstraints(classInput, 1, 1);

        Label gradeLabel = new Label("Grade:");
        GridPane.setConstraints(gradeLabel, 0, 2);
        TextField gradeInput = new TextField();
        GridPane.setConstraints(gradeInput, 1, 2);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 3);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                String className = classInput.getText();
                float grade = Float.parseFloat(gradeInput.getText());
                studentDAO.addGrade(studentId, className, grade);
                addGradeStage.close();
                primaryStage.setFullScreen(true);
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 3);
        backButton.setOnAction(e -> {
            addGradeStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        grid.getChildren().addAll(idLabel, idInput, classLabel, classInput, gradeLabel, gradeInput, submitButton, backButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/style.css");
        addGradeStage.setScene(scene);
        addGradeStage.setFullScreen(true);
        addGradeStage.show();
    }

    private void displayAllGrades() {
        Stage displayGradesStage = new Stage();
        displayGradesStage.setTitle("Display All Grades");

        displayGradesStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 1);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                List<ClassInfo> classes = studentDAO.getAllGrades(studentId);

                Stage gradesStage = new Stage();
                gradesStage.setTitle("Grades for Student ID " + studentId);

                gradesStage.setFullScreenExitHint("");

                GridPane gradesGrid = new GridPane();
                gradesGrid.setPadding(new Insets(10, 10, 10, 10));
                gradesGrid.setVgap(8);
                gradesGrid.setHgap(10);
                gradesGrid.setAlignment(Pos.CENTER);

                int row = 0;
                for (ClassInfo classInfo : classes) {
                    Label classLabel = new Label("Class: " + classInfo.getClassName());
                    GridPane.setConstraints(classLabel, 0, row++);
                    gradesGrid.getChildren().add(classLabel);
                    for (float grade : classInfo.getGrades()) {
                        Label gradeLabel = new Label("Grade: " + grade);
                        GridPane.setConstraints(gradeLabel, 0, row++);
                        gradesGrid.getChildren().add(gradeLabel);
                    }
                }

                Button backButton = new Button("Back");
                GridPane.setConstraints(backButton, 0, row);
                backButton.setOnAction(event -> {
                    gradesStage.close();
                    primaryStage.setFullScreen(true);
                    primaryStage.show();
                });
                gradesGrid.getChildren().add(backButton);

                Scene gradesScene = new Scene(gradesGrid, 400, 400);
                gradesScene.getStylesheets().add("/style.css");
                gradesStage.setScene(gradesScene);
                gradesStage.setFullScreen(true);
                gradesStage.show();

                displayGradesStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 1);
        backButton.setOnAction(e -> {
            displayGradesStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(backButton, submitButton);
        GridPane.setConstraints(buttonBox, 1, 1);

        grid.getChildren().addAll(idLabel, idInput, buttonBox);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/style.css");
        displayGradesStage.setScene(scene);
        displayGradesStage.setFullScreen(true);
        displayGradesStage.show();
    }

    private void deleteGrade() {
        Stage deleteGradeStage = new Stage();
        deleteGradeStage.setTitle("Delete Grade");

        deleteGradeStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Student ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 0);

        Label classLabel = new Label("Class Name:");
        GridPane.setConstraints(classLabel, 0, 1);
        TextField classInput = new TextField();
        GridPane.setConstraints(classInput, 1, 1);

        Label gradeLabel = new Label("Grade:");
        GridPane.setConstraints(gradeLabel, 0, 2);
        TextField gradeInput = new TextField();
        GridPane.setConstraints(gradeInput, 1, 2);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 3);
        submitButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(idInput.getText());
                String className = classInput.getText();
                float grade = Float.parseFloat(gradeInput.getText());
                studentDAO.deleteGrade(studentId, className, grade);
                deleteGradeStage.close();
                primaryStage.setFullScreen(true);
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 3);
        backButton.setOnAction(e -> {
            deleteGradeStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        grid.getChildren().addAll(idLabel, idInput, classLabel, classInput, gradeLabel, gradeInput, submitButton, backButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/style.css");
        deleteGradeStage.setScene(scene);
        deleteGradeStage.setFullScreen(true);
        deleteGradeStage.show();
    }

    private void retrieveAllProfessors() {
        Stage retrieveProfessorsStage = new Stage();
        retrieveProfessorsStage.setTitle("All Professors");

        retrieveProfessorsStage.setFullScreenExitHint("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        try {
            IProfessorDAO professorDAO = new ProfessorDAO();
            List<Professor> professors = professorDAO.getAllProfessors();
            int row = 0;
            for (Professor professor : professors) {
                Label professorLabel = new Label("Professor ID: " + professor.getId() + ", Name: " + professor.getFirstName() + " " + professor.getLastName() + ", Faculty: " + professor.getFaculty() + ", Class Name: " + professor.getClassName());
                GridPane.setConstraints(professorLabel, 0, row++);
                grid.getChildren().add(professorLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            retrieveProfessorsStage.close();
            primaryStage.setFullScreen(true);
            primaryStage.show();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, backButton);

        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add("/style.css");
        retrieveProfessorsStage.setScene(scene);
        retrieveProfessorsStage.setFullScreen(true);
        retrieveProfessorsStage.show();
    }
}