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
}