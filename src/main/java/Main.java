import Models.Department;
import Models.Employee;
import Repositories.DBConnection;
import Repositories.DepartmentRepo;
import Repositories.EmployeeRepo;

import java.sql.*;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {


        EmployeeRepo employeeRepo = new EmployeeRepo();


        System.out.println(employeeRepo.selectById(5));

        System.out.println("\n\n//////////////////////////////////////////////////////////\n");

        employeeRepo.insertEmployee(new Employee(1900488, "Yassin Mohamed Zafan",
                "yassenm.zafan@gmail.com", 1));
        System.out.println(employeeRepo.selectById(1900488));

        System.out.println("\n\n//////////////////////////////////////////////////////////\n");

        System.out.println("Deleting Yassin from DB " + (employeeRepo.deleteEmployee(1900488)));

        System.out.println("\n\n//////////////////////////////////////////////////////////\n");



        List<Employee> employees = employeeRepo.selectAll();
        System.out.printf("%10s %17s %20s %25s\n","ID", "Name", "Email", "Department" );
        for (Employee employee : employees) {
            System.out.printf("%10d %20s %30s %10d\n",
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getDepartmentId());
        }


        System.out.println("\n\n//////////////////////////////////////////////////////////\n");

        DepartmentRepo departmentRepo = new DepartmentRepo();
        List<Department> departments = departmentRepo.getAllDepartments();
        for (Department department : departments) {
            System.out.println(department);
        }






    }

}
