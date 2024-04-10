import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem managementSystem = new EmployeeManagementSystem();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Show All Employees");
            System.out.println("4. Save Employees to File");
            System.out.println("5. Load Employees from File");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee Type (Experience/Fresher/Intern): ");
                    String employeeType = scanner.nextLine();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Enter Birth Day: ");
                    String birthDay = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    if (employeeType.equalsIgnoreCase("Experience")) {
                        System.out.print("Enter Experience in Years: ");
                        int expInYear = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter Professional Skill: ");
                        String proSkill = scanner.nextLine();

                        Experience experience = new Experience(id, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
                        managementSystem.addEmployee(experience);
                    } else if (employeeType.equalsIgnoreCase("Fresher")) {
                        System.out.print("Enter Graduation Date: ");
                        String graduationDate = scanner.nextLine();

                        System.out.print("Enter Graduation Rank: ");
                        String graduationRank = scanner.nextLine();

                        System.out.print("Enter Education: ");
                        String education = scanner.nextLine();

                        FresherNV fresher = new FresherNV(id, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
                        managementSystem.addEmployee(fresher);
                    } else if (employeeType.equalsIgnoreCase("Intern")) {
                        System.out.print("Enter Majors: ");
                        String majors = scanner.nextLine();

                        System.out.print("Enter Semester: ");
                        String semester = scanner.nextLine();

                        System.out.print("Enter University Name: ");
                        String universityName = scanner.nextLine();

                        InternNV intern = new InternNV(id, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
                        managementSystem.addEmployee(intern);
                    } else {
                        System.out.println("Invalid Employee Type.");
                    }
                    break;

                case 2:
                    // Remove Employee
                    System.out.print("Enter Employee ID to remove: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    managementSystem.removeEmployee(employeeId);
                    break;

                case 3:
                    // Show All Employees
                    managementSystem.showAllEmployees();
                    break;

                case 4:
                    // Save Employees to File
                    managementSystem.saveEmployeesToFile();
                    System.out.println("Employees saved to file.");
                    break;

                case 5:
                    // Load Employees from File
                    managementSystem.loadEmployeesFromFile();
                    System.out.println("Employees loaded from file.");
                    break;

                case 0:
                    // Exit
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}