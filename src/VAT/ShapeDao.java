package VAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShapeDao {
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/shapes";
        String username = "root";
        String password = null;

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
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