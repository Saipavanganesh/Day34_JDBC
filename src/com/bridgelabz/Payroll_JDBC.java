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
            System.out.println(id);
        }
        connection.close();
    }
}
