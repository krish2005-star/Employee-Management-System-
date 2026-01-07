package dao;

import model.Employee;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//CRUD OPERATIONS
public class EmployeeDAO {
    // CREATE
    public boolean addEmployee(Employee employee) {
        String sql = "insert into employees(name,email,department,salary,phone) values(?,?,?,?,?)";

        try(
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,employee.getName());
            pstmt.setString(2,employee.getEmail());
            pstmt.setString(3,employee.getDepartment());
            pstmt.setDouble(4,employee.getSalary());
            pstmt.setString(5,employee.getPhone());

            int rows = pstmt.executeUpdate();
            if(rows>0){
                return true;
            }

        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    //READ
    public List<Employee> getAllEmployees() {
        String sql = "select * from employees";
        List<Employee> employees = new ArrayList<>();
        try(
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                String phone = rs.getString("phone");

                Employee emp = new Employee(id,name,email,department,salary,phone);
                employees.add(emp);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return employees;
    }

    //READ
    public Employee getEmployee(int id) {
        String sql = "select * from employees where id = ?";
        Employee employee = null;
        try(
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
               employee = new Employee(
                       rs.getInt("id"),
                       rs.getString("name"),
                       rs.getString("email"),
                       rs.getString("department"),
                       rs.getDouble("salary"),
                       rs.getString("phone")
               );
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return employee;
    }

    //UPDATE
    public boolean updateEmployee(Employee employee) {
        String sql="update employees set name=?,email=?,department=?,salary=?,phone=? where id=?";
        try(
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,employee.getName());
            pstmt.setString(2,employee.getEmail());
            pstmt.setString(3,employee.getDepartment());
            pstmt.setDouble(4,employee.getSalary());
            pstmt.setString(5,employee.getPhone());
            pstmt.setInt(6,employee.getId());
            int rows = pstmt.executeUpdate();
            if(rows>0){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    //DELETE
    public boolean deleteEmployee(int id) {
        String sql="delete from employees where id=?";
        try(
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            int rows = pstmt.executeUpdate();
            if(rows>0){
                return true;
            }
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
