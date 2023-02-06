package com.bridgelabz;

import java.sql.*;

public class Payroll_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "letmein";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
        while(resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String salary = resultSet.getString("salary");
            String start_date = resultSet.getString("start_date");
            String gender = resultSet.getString("gender");
            System.out.println(id + " " + name + " " + salary + " " + start_date + " " + gender);
        }
        connection.close();
    }
}
