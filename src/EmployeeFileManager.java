import java.io.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeFileManager {
    private static final String FILE_PATH = "employees.txt";

    public List<EmployeeNV> readEmployeesFromFile() {
        List<EmployeeNV> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int id = Integer.parseInt(employeeData[0]);
                String fullName = employeeData[1];
                String birthDay = employeeData[2];
                String phone = employeeData[3];
                String email = employeeData[4];
                String employeeType = employeeData[5];
                int employeeCount = Integer.parseInt(employeeData[6]);

                if (employeeType.equalsIgnoreCase("Experience")) {
                    int expInYear = Integer.parseInt(employeeData[7]);
                    String proSkill = employeeData[8];
                    Experience experience = new Experience(id, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
                    employees.add(experience);
                } else if (employeeType.equalsIgnoreCase("Fresher")) {
                    String graduationDate = employeeData[7];
                    String graduationRank = employeeData[8];
                    String education = employeeData[9];
                    FresherNV fresher = new FresherNV(id, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
                    employees.add(fresher);
                } else if (employeeType.equalsIgnoreCase("Intern")) {
                    String majors = employeeData[7];
                    String semester = employeeData[8];
                    String universityName = employeeData[9];
                    InternNV intern = new InternNV(id, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
                    employees.add(intern);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading employees from file: " + e.getMessage());
        }

        return employees;
    }

    public void writeEmployeesToFile(List<EmployeeNV> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (EmployeeNV employee : employees) {
                writer.write(employee.getID() + "," + employee.getFullName() + "," + employee.getBirthDay() + "," +
                        employee.getPhone() + "," + employee.getEmail() + "," + employee.getEmployeeType() + ","
                       );

                if (employee instanceof Experience) {
                    Experience experience = (Experience) employee;
                    writer.write("," + experience.getExpInYear() + "," + experience.getProSkill());
                } else if (employee instanceof FresherNV) {
                    FresherNV fresher = (FresherNV) employee;
                    writer.write("," + fresher.getGraduationDate() + "," + fresher.getGraduationRank() + "," + fresher.getEducation());
                } else if (employee instanceof InternNV) {
                    InternNV intern = (InternNV) employee;
                    writer.write("," + intern.getMajors() + "," + intern.getSemester() + "," + intern.getUniversityName());
                }

                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing employees to file: " + e.getMessage());
        }
    }
}