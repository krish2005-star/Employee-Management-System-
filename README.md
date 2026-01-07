# Employee Management System

A console-based Employee Management System built with Java and PostgreSQL that enables CRUD operations for managing employee records efficiently.

## Features

- ✅ Add new employees with validation
- ✅ View all employees
- ✅ Search employees by ID
- ✅ Update employee information
- ✅ Delete employees with confirmation
- ✅ Email uniqueness validation
- ✅ Input validation (email format, phone number, salary range)

## Technologies Used

- **Java** - Core programming language
- **JDBC** - Database connectivity
- **PostgreSQL** - Relational database
- **SQL** - Database queries

## Database Schema
```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    phone VARCHAR(15)
);
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or higher)
- PostgreSQL (12 or higher)
- PostgreSQL JDBC Driver
- IDE (IntelliJ IDEA / Eclipse / VS Code)

## Usage

### Main Menu Options
```
========================================
   EMPLOYEE MANAGEMENT SYSTEM
========================================
1. Add Employee
2. View All Employees
3. Search Employee by ID
4. Update Employee
5. Delete Employee
6. Exit
========================================
```

### Example Operations

**Adding an Employee:**
```
Enter Name: Krishna
Enter Email: krishna@example.com
Enter Department: IT
Enter Salary: 20000
Enter Phone: 1234432110
Employee added successfully!
```

## Project Structure
```
EmployeeManagementSys/
├── src/
│   ├── model/
│   │   └── Employee.java           # Employee POJO
│   ├── dao/
│   │   └── EmployeeDAO.java        # Database operations
│   ├── util/
│   │   └── DatabaseConnection.java # Database connection utility
│   └── main/
│       └── Main.java               # Main application
├── .gitignore
└── README.md
```

## Security Features

- ✅ PreparedStatement to prevent SQL injection
- ✅ Email uniqueness constraint
- ✅ Input validation and sanitization
- ✅ Credentials stored in external config file (not in code)
- ✅ config.properties excluded from version control

## Key Highlights

- **Clean Architecture**: Separation of concerns with Model-DAO-Main pattern
- **Error Handling**: Comprehensive exception handling with user-friendly messages
- **Input Validation**: Email format, phone number, and salary range validation
- **Database Constraints**: Unique email enforcement at database level
- **Resource Management**: Proper connection closing using try-with-resources
- **User Experience**: Clear menu interface with confirmation prompts

## What I Learned

- JDBC connectivity and CRUD operations
- PreparedStatement for SQL injection prevention
- Database transaction management
- Exception handling in database operations
- Object-oriented design patterns (DAO pattern)
- Input validation and data sanitization
- PostgreSQL database design and constraints

## Future Enhancements

- [ ] Provide Employee statistics
- [ ] Add authentication and authorization
- [ ] Export employee data to CSV/Excel
- [ ] Add employee attendance tracking
- [ ] Implement pagination for large datasets
- [ ] Add GUI using JavaFX or Swing
- [ ] Generate PDF reports
- [ ] Add employee photos

## Author

**Mogilepalli Naga Sai Krishna Kshitij**

- 📧 Email: m.krishna0513@gmail.com
- 💼 LinkedIn: [LinkedIn](https://www.linkedin.com/in/naga-sai-krishna-kshitij-mogilepalli-7b907a2b9/)
- 🌐 Portfolio: [mnskk.framer.website](https://mnskk.framer.website/)
- 💻 GitHub: [@krish2005-star](https://github.com/krish2005-star)

---

⭐ If you found this project helpful, please give it a star!