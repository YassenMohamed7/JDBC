import Models.Department;
import Models.Employee;
import Models.Project;
import Repositories.DBConnection;
import Repositories.DepartmentRepo;
import Repositories.EmployeeRepo;
import Repositories.ProjectRepo;

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

        Department department = new Department(103, "CSE", "Menouf");
        departmentRepo.insertDepartment(department);
        List<Department> departments = departmentRepo.getAllDepartments();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("After deleting department 103: ");
        departmentRepo.deleteDepartment(103);
        Department department103 = departmentRepo.getDepartment(103);
        if(department103 == null){
            System.out.println("Department 103 not found");
        }else
            System.out.println(department103);


        System.out.println("//////////////////////////////////////////");


        ProjectRepo projectRepo = new ProjectRepo();

        List<Project>  projects = projectRepo.getAllProjects();
        projects.forEach(System.out::println);




    }

}
