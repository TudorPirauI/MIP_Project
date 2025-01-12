package Models;

import Interfaces.IProfessorDAO;
import org.example.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IProfessorDAO {
    private Connection connection;

    public ProfessorDAO() {
        this.connection = DatabaseUtil.getConnection();
    }

    @Override
    public List<Professor> getAllProfessors() throws SQLException {
        List<Professor> professors = new ArrayList<>();
        String query = "SELECT * FROM professor";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                professors.add(new Professor(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("faculty"),
                        rs.getString("class_name")
                ));
            }
        }
        return professors;
    }
}