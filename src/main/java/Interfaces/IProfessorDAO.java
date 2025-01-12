package Interfaces;

import Models.Professor;

import java.sql.SQLException;
import java.util.List;

public interface IProfessorDAO {
    List<Professor> getAllProfessors() throws SQLException;
}


