import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<EmployeeNV> employees;
    private EmployeeFileManager fileManager;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        fileManager = new EmployeeFileManager();
    }

    public void addEmployee(EmployeeNV employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getID() == employeeId);
    }

    public void showAllEmployees() {
        for (EmployeeNV employee : employees) {
            employee.showInfo();
            System.out.println();
        }
    }

    public void saveEmployeesToFile() {
        fileManager.writeEmployeesToFile(employees);
    }

    public void loadEmployeesFromFile() {
        employees = fileManager.readEmployeesFromFile();
    }
}
