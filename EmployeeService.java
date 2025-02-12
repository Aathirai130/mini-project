package employeeSystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	
	private List<Employee> employees;
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employees = new ArrayList<>();
        this.employeeDAO = new EmployeeDAO();
    }

    public void addEmployee(String name, String department, double salary) {
        Employee employee = new Employee(0, name, department, salary);
        employeeDAO.addEmployee(employee);
    }

    public void viewEmployees() {
        employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void searchEmployee(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee Found: " + employee);
        } else {
            System.out.println("Employee Not Found.");
        }
    }

    public void deleteEmployee(int id) {
        if (employeeDAO.deleteEmployee(id)) {
            System.out.println("Employee Deleted Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }
    }

}
