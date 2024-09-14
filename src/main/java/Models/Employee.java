package Models;


public class Employee {
    private int id;
    private String name;
    private String email;
    private int departmentId;

    public Employee(int id, String name, String email, int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return String.format("{\n\tId: %d,\n\tName: %s,\n\tEmail: %s,\n\tDepartmentId: %d\n}", id, name, email, departmentId);
    }
}
