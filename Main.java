package employeeSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 EmployeeService employeeService = new EmployeeService();
	        Scanner scanner = new Scanner(System.in);
	        boolean continueLoop;

	        do {
	            System.out.println("\nEmployee Management System");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View All Employees");
	            System.out.println("3. Search Employee by ID");
	            System.out.println("4. Delete Employee");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            try {
	                int choice = scanner.nextInt();
	                scanner.nextLine(); // Consume newline

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter Employee Name: ");
	                        String name = scanner.nextLine();
	                        System.out.print("Enter Department: ");
	                        String department = scanner.nextLine();
	                        System.out.print("Enter Salary: ");
	                        double salary = scanner.nextDouble();
	                        employeeService.addEmployee(name, department, salary);
	                        break;
	                    case 2:
	                        employeeService.viewEmployees();
	                        break;
	                    case 3:
	                        System.out.print("Enter Employee ID: ");
	                        int searchId = scanner.nextInt();
	                        employeeService.searchEmployee(searchId);
	                        break;
	                    case 4:
	                        System.out.print("Enter Employee ID to Delete: ");
	                        int deleteId = scanner.nextInt();
	                        employeeService.deleteEmployee(deleteId);
	                        break;
	                    case 5:
	                        System.out.println("Exiting...");
	                        scanner.close();
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice. Try again.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a valid number.");
	                scanner.next(); // Consume invalid input
	            }

	            // Ask the user if they want to continue
	            System.out.print("Do you want to continue? (yes/no): ");
	            String response = scanner.next().toLowerCase();
	            continueLoop = response.equals("yes");

	        } while (continueLoop);

	        System.out.println("Thank you for using Employee Management System!");
	        scanner.close();
	    }
	}


