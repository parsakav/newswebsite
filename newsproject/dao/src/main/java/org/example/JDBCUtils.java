package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;


public class JDBCUtils {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/newswebsite";
    private static String jdbcUsername = "parsa";
    private static String jdbcPassword = "parsa1381@.Com";



    public static Connection getConnection() {
if(!DatabaseConfig.isInitialized()){
    try {
        DatabaseConfig.init();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static Date getSQLDate(LocalDate date) {

        return Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

    public static class DatabaseConfig {

        private static boolean config = false;


        public static void init() throws SQLException, FileNotFoundException {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Getting the connection
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            ScriptRunner sr = new ScriptRunner(con);

            Reader reader = new BufferedReader(new FileReader("/home/parsa/newswebsite.sql"));
            sr.runScript(reader);
            sr.closeConnection();
            try {
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            config = true;
        }

        public static boolean isInitialized() {
            return config;

        }
    }
}