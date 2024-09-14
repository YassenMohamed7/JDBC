package Repositories;

import Models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepo {

    private final Connection connection;


    public DepartmentRepo() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public int insertDepartment(Department department) throws SQLException {
        String query = "INSERT INTO department (id, name, location) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, department.getId());
        preparedStatement.setString(2, department.getName());
        preparedStatement.setString(3, department.getLocation());
        return preparedStatement.executeUpdate();
    }

    public int deleteDepartment(int id) throws SQLException {
        String query = "DELETE FROM department WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }
    public Department getDepartment(int id) throws SQLException {
        String query = "SELECT * FROM department WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Department(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
        return null;
    }
    public List<Department> getAllDepartments() throws SQLException {
        String query = "Select * from department";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()){
            Department department = new Department(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
            departments.add(department);
        }
        return departments;
    }


}
