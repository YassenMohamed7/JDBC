package Repositories;

import Models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepo {

    private final Connection connection;

    public ProjectRepo() throws SQLException {
        this.connection = DBConnection.getConnection();
    }


    public int insertProject(Project project) throws SQLException {
        String query = "Insert into project values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, project.getId());
        preparedStatement.setString(2, project.getName());
        preparedStatement.setDate(3, (java.sql.Date)project.getStartDate());
        preparedStatement.setInt(4, project.getId());

        return preparedStatement.executeUpdate();
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();
        String query = "Select id, name, startDate, dept_id from project";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
            projects.add(new Project(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getInt(4)));

        return projects;
    }

    public Project getProjectById(int id) throws SQLException {
        String query = "Select id, name, startDate, dept_id from project where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
       return  new Project(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getDate(3),
                resultSet.getInt(4));
    }
    public int deleteProjectById(int id) throws SQLException {
        String query = "Delete from project where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

}
