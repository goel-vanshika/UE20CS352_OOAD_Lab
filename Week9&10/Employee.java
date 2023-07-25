
public class Employee {
    private String empName;
    private String role;

    public Employee(String empName, String role) {
        this.empName = empName;
        this.role = role;
    }

    public String getEmpName() {
        return empName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}