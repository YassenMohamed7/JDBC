package Repositories;

import Models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private Connection connection;

    public EmployeeRepo() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> selectAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(new Employee(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)));
        }
        return employees;
    }

    public Employee selectById(int id) throws SQLException {
        PreparedStatement  preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet =  preparedStatement.executeQuery();
        resultSet.next();
        Employee employee = new Employee(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4));

        return  employee;
    }
    public int insertEmployee(Employee employee) throws SQLException {

       String query = "insert into employee(id, name, email, dept_id) values(?,?,?,?)";
       PreparedStatement preparedStatement = connection.prepareStatement(query);
       preparedStatement.setInt(1, employee.getId());
       preparedStatement.setString(2, employee.getName());
       preparedStatement.setString(3, employee.getEmail());
       preparedStatement.setInt(4, employee.getDepartmentId());

       return  preparedStatement.executeUpdate();
    }

    public int deleteEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }
}
