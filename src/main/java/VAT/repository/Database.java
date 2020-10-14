package VAT.repository;

import VAT.Shape;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract class Database<E> {
    //  Connection variables
    private static final String URL = "jdbc:mysql://localhost:3306/shapes";
    private static final String USER = "App";
    private static final String PASS = "QGj5s#8_EBW9Bu&";

    @FunctionalInterface
    interface UsesStatement<R> {
        R apply(PreparedStatement statement) throws SQLException;
    }

    public <R> R query(String sql, UsesStatement<R> operator ) {

        try (java.sql.Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            R result = operator.apply(statement);

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    abstract E recordToEntity(ResultSet resultSet) throws SQLException;

// OLD DEFAULT CONNECTION LAYER:
//    public static void main(String[] args){
//        System.out.println("Connecting database...");
//
//        try (java.sql.Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
//            System.out.println("Database connected!");
//
//            Statement statement = connection.createStatement();
//
//            ResultSet results = statement.executeQuery("SELECT * FROM shape");
//
//
//            while (results.next()) {
//                System.out.println(results.getInt("id"));
//                System.out.println(results.getString("name"));
//            }
//
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
//    }
}
