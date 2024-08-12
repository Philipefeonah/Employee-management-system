package EmployeeApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeDaoInterface dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee Management Application");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the Employee \n" +
                    "5. Delete the Employee\n");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Employee employee = new Employee();
                    System.out.print("Enter Id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter name: ");
                    name = scanner.next();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setAge(age);
                    dao.createEmployee(employee);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.print("Enter id to show details: ");
                    id = scanner.nextInt();
                    dao.showEmployeeBasedOnID(id);
                    break;
                case 4:
                    System.out.print("Enter id to update details: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the new name: ");
                    name = scanner.next();
                    dao.updateEmployee(id, name);
                    break;
                case 5:
                    System.out.print("Enter the id to delete: ");
                    id = scanner.nextInt();
                    dao.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you for using our Application");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !!");
                    break;

            }
        }while (true);

    }


}
