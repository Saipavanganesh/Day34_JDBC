package com.bridgelabz;

import java.sql.*;

public class Payroll_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "letmein";
        String updateQuery = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
//        statement.executeUpdate(updateQuery);
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setInt(1,3000000);
        ps.setString(2,"Raj");
        ps.executeUpdate();
        String query = "SELECT * FROM employee_payroll";
        ResultSet resultSet = statement.executeQuery(query);
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
