package Repository;
import java.sql.*;

abstract class Database<E> {
    //  Connection variables
    private static final String URL = "jdbc:mysql://localhost:3306/shapes";
    private static final String USER = "root";
    private static final String PASS = "";

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
}
