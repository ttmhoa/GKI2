import java.sql.*;
public class EmployeeDatabaseManagerv {
  JDBC connection = new JDBC();
  public void insertEmployee(EmployeeNV employee){
      try (Connection conn= connection.getConnection()) {
          String query = "INSERT INTO employees (id, full_name, birth_day, phone, email, employee_type) VALUES (?, ?, ?, ?, ?, ?)";

          PreparedStatement statement = conn.prepareStatement(query);
          statement.setInt(1, employee.getID());
          statement.setString(2, employee.getFullName());
          statement.setString(3, employee.getBirthDay());
          statement.setString(4, employee.getPhone());
          statement.setString(5, employee.getEmail());
          statement.setString(6, employee.getEmployeeType());


          statement.executeUpdate();
      } catch (SQLException e) {
          System.out.println("Error inserting employee into database: " + e.getMessage());
      }
  }
    public void updateEmployee(EmployeeNV employee) {
        try (Connection conn= connection.getConnection()) {
            String query = "UPDATE employees SET full_name = ?, birth_day = ?, phone = ?, email = ?, employee_type = ? WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getBirthDay());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getEmployeeType());
            statement.setInt(6, employee.getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating employee in database: " + e.getMessage());
        }
    }
    public int getEmployeeCount() {
        int employeeCount = 0;

        try (Connection conn= connection.getConnection()) {
            String query = "SELECT COUNT(*) FROM employees";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                employeeCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee count from database: " + e.getMessage());
        }

        return employeeCount;
    }

    public void deleteEmployee(int employeeId) {
        try (Connection conn= connection.getConnection()) {
            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting employee from database: " + e.getMessage());
        }

    }

}
