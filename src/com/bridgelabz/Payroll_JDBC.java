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
        String query = "SELECT SUM(salary), AVG(salary), MIN(salary), MAX(salary), COUNT(salary) FROM employee_payroll WHERE gender = 'M' GROUP BY gender;";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            String sumOfSalary = resultSet.getString("SUM(salary)");
            String avgOfSalary = resultSet.getString("AVG(salary)");
            String minOfSalary = resultSet.getString("MIN(salary)");
            String maxOfSalary = resultSet.getString("MAX(salary)");
            String count = resultSet.getString("COUNT(salary)");
            System.out.println(sumOfSalary + " " + avgOfSalary + " " + minOfSalary + " " + maxOfSalary + " " + count);
        }
        connection.close();
    }
}
