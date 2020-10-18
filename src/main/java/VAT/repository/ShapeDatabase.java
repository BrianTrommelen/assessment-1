package VAT.repository;

import VAT.Shape;
import VAT.Main;
import VAT.Shapes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShapeDatabase extends Database implements DatabaseInterface {
    @Override
    public void save(Shape shape) {
        query("INSERT INTO shape (name) VALUES (?)", statement -> {
            statement.setString(1, shape.getName());

            return statement.execute();
        });
    }

    @Override
    public void update(int id, Shape shape) {
        query("UPDATE shape SET name = ? WHERE id = ?", statement -> {
            statement.setString(1, shape.getName());
            statement.setInt(2, id);

            return statement.execute();
        });
    }

    @Override
    public Shape getById(int id) {
        return (Shape) query("SELECT * FROM shape WHERE id = ?", statement -> {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return recordToEntity(resultSet);
            } else {
                return null;
            }
        });
    }

    @Override
    public void delete(Shape shape) {

    }

    @Override
    public void delete(int id) {
        query("DELETE FROM shape WHERE id = ?", statement -> {
            statement.setInt(1, id);

            return statement.execute();
        });
    }

    @Override
    public void deleteAll() {
        query("DELETE FROM shape", PreparedStatement::execute);
    }

    public List<Shapes> getAll() {
        return (List<Shapes>) query("SELECT * FROM shape", statement -> {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shape");
            List<Shapes> result = new ArrayList<>();

            while (resultSet.next()) {
                Shape shape = recordToEntity(resultSet);
                result.add(shape);
            }
            return result;
        });
    }


    @Override
    Shape recordToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        //returns shape object

        return new Shape(id, name);
    }

    //    public int getSingle() {
//        return super.query("SELECT * FROM shape WHERE id = ?", );
//    }
//
//    public void updateSingle(Shape shape) {
//        String sql = "UPDATE shape SET name = ? WHERE id = ?";
//
//
//        super.query(sql);
//    }
}