package EmployeeApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoInterface{
    Connection con;

    @Override
    public void createEmployee(Employee employee) {
        con = DBConnection.createDBConnection();
        String query = "insert into employee values(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3,employee.getSalary());
            preparedStatement.setInt(4, employee.getAge());
            int count = preparedStatement.executeUpdate();
            if(count!=0)
                System.out.println("Employee inserted successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "select * from employee";
        System.out.println("Employee Details : ");
        System.out.println("-------------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
        System.out.println("-------------------------------------------------");
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getInt(4));
                System.out.println("-------------------------------------------------");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from employee where id = " + id;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getInt(4));
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employee set name=? where id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int count = preparedStatement.executeUpdate();
            if(count!=0) {
                System.out.println("Employee Details updated successfully !!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if(count!=0){
                System.out.println("Employee Deleted Successfully!!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
