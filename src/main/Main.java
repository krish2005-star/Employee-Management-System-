package main;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;
import java.util.Scanner;

public class Main{

    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static Scanner sc = new Scanner(System.in);

    public static void diaplayMenu(){
        System.out.println("\n===========================================");
        System.out.println("Employee Management System");
        System.out.println("_____________________________________________");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by Id");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.println("===========================================");
        System.out.println("Enter your choice : ");
    }


    public static void main() {
        while(true){
            diaplayMenu();
            int choice = sc.nextInt();
            switch (choice){
                case 1: addEmployee();
                break;
                case 2: getAllEmployees();
                break;
                case 3: getEmployee();
                break;
                case 4: updateEmployee();
                break;
                case 5: deleteEmployee();
                break;
                case 6: System.out.println("Exiting....\n===========================================");
                return;
                default: System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void addEmployee(){
        System.out.println("\n-----Add Employee-----");
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (!isValidName(name)) {
            System.out.println("Invalid name, name must be at least 2 characters.");
            return;
        }
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format, (example: user@domain.com)");
            return;
        }
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        if (!isValidName(department)) {
            System.out.println("Invalid department name");
            return;
        }
        System.out.print("Enter Salary: ");
        double salary;
        salary = sc.nextDouble();
        sc.nextLine(); // Consume newline
        if (!isValidSalary(salary)) {
            System.out.println("Invalid salary, must be between 10,000 and 10,000,000.");
            return;
        }
        System.out.print("Enter Phone (10 digits): ");
        String phone = sc.nextLine();
        if (!isValidPhone(phone)) {
            System.out.println("Invalid phone number, must be 10 digits starting with 6/7/8/9.");
            return;
        }

        Employee employee = new Employee(name,email,department,salary,phone);
        if(employeeDAO.addEmployee(employee))
            System.out.println("Employee Added Successfully");
        else
            System.out.println("Failed to add Employee");
    }

    public static void getAllEmployees(){
        List<Employee> employees = employeeDAO.getAllEmployees();
        if(employees.isEmpty()) {
            System.out.println("No Employees Found");
            return;
        }

        for(Employee employee : employees){
            System.out.println(employee);
        }
        System.out.println("Total Employees Found : "+employees.size());
    }

    public static void getEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        int id = sc.nextInt();
        Employee employee = employeeDAO.getEmployee(id);
        if(employee == null)
            System.out.println("Employee Not Found");
        else
            System.out.println(employee.toString());
    }

    public static void updateEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        Employee checkEmployee = employeeDAO.getEmployee(id);
        if(checkEmployee == null) {
            System.out.println("Employee Not Found");
            return;
        }

        System.out.println(checkEmployee.toString());
        System.out.println("Enter the new details:\n---------------------------");
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Email : ");
        String email = sc.nextLine();
        System.out.println("Enter Department : ");
        String department = sc.nextLine();
        System.out.println("Enter Salary : ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Phone Number : ");
        String phone = sc.nextLine();
        Employee employee = new Employee(id,name,email,department,salary,phone);
        if(employeeDAO.updateEmployee(employee))
            System.out.println("Employee Updated Successfully");
        else
            System.out.println("Failed to update Employee");
    }

    public static void deleteEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        Employee employee = employeeDAO.getEmployee(id);
        if(employee == null) {
            System.out.println("Employee Not Found");
            return;
        }
        System.out.println("Are you sure you want to delete the employee with ID("+id+")?\n(yes/no)");
        String choice = sc.next();
        if(choice.equals("yes")){
            employeeDAO.deleteEmployee(id);
            System.out.println("Employee Deleted Successfully");
        }
        else
            System.out.println("Failed to delete Employee");
    }

    // Validation check of input
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    private static boolean isValidPhone(String phone) {
        return phone.matches("^[6-9]\\d{9}$"); // 10 digits starting with 6-9
    }

    private static boolean isValidSalary(double salary) {
        return salary >= 10000 && salary <= 10000000; // Reasonable range
    }

    private static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }
}