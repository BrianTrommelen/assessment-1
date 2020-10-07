package VAT;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/shapes";
        String username = "root";
        String password = "";

        System.out.println("Connecting database...");

        try (java.sql.Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM shape");


            while (results.next()) {
                System.out.println(results.getInt("id"));
                System.out.println(results.getString("name"));
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


}