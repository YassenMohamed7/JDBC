package Models;

import java.util.Date;

public class Project {
    private int id;
    private String name;
    private Date startDate;
    private int dept_it;

    public Project() {
    }

    public Project(int id, String name, Date startDate, int dept_it) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.dept_it = dept_it;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDept_it() {
        return dept_it;
    }

    public void setDept_it(int dept_it) {
        this.dept_it = dept_it;
    }
}
