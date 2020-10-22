package Repository;

import Shape.Shape;
import Shapes.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShapeDatabase extends Database implements DatabaseInterface {
    @Override
    public void save(Shape shape) {
        query("INSERT INTO shape_information (shapeId, name, radius, width, length, height, volume) VALUES (?, ?, ?, ?, ?, ?, ?)", statement -> {

            statement.setInt(1, shape.getShapeNum());

            statement.setString(2, shape.getName());

            if (!(shape.getRadius() == 0)) {
                statement.setDouble(3, shape.getRadius());
            } else {
                statement.setString(3, null);
            }

            if (!(shape.getWidth() == 0)) {
                statement.setDouble(4, shape.getWidth());
            } else {
                statement.setString(4, null);
            }

            if (!(shape.getLength() == 0)) {
                statement.setDouble(5, shape.getLength());
            } else {
                statement.setString(5, null);
            }

            if (!(shape.getHeight() == 0)) {
                statement.setDouble(6, shape.getHeight());
            } else {
                statement.setString(6, null);
            }


            if (!(shape.getVolume() == 0)) {
                statement.setDouble(7, shape.getVolume());
            } else {
                statement.setDouble(7, 0);
            }

            return statement.execute();
        });
    }

    @Override
    public void update(int id, Shape shape) {
        query("UPDATE shape_information SET shapeId = ?, name = ?, radius = ?, width = ?, length = ?, height = ?, volume = ?  WHERE id = ?", statement -> {
            statement.setInt(1, shape.getShapeNum());

            statement.setString(2, shape.getName());

            if (!(shape.getRadius() == 0)) {
                statement.setDouble(3, shape.getRadius());
            } else {
                statement.setString(3, null);
            }

            if (!(shape.getWidth() == 0)) {
                statement.setDouble(4, shape.getWidth());
            } else {
                statement.setString(4, null);
            }

            if (!(shape.getLength() == 0)) {
                statement.setDouble(5, shape.getLength());
            } else {
                statement.setString(5, null);
            }

            if (!(shape.getHeight() == 0)) {
                statement.setDouble(6, shape.getHeight());
            } else {
                statement.setString(6, null);
            }

            if (!(shape.getVolume() == 0)) {
                statement.setDouble(7, shape.getVolume());
            } else {
                statement.setDouble(7, 0);
            }

            statement.setInt(8, id);

            return statement.execute();
        });
    }

    @Override
    public Shape getById(int id) {
        return (Shape) query("SELECT * FROM shape_information WHERE id = ?", statement -> {
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
        query("DELETE FROM shape_information WHERE id = ?", statement -> {
            statement.setInt(1, id);

            return statement.execute();
        });
    }

    @Override
    public void deleteAll() {
        query("DELETE FROM shape_information", PreparedStatement::execute);
    }

    public List getAll() {
        String query = "SELECT * FROM shape_information";

        return (List<Shape>) query(query, statement -> {
            ResultSet resultSet = statement.executeQuery(query);
            List<Shape> result = new ArrayList<>();

            while (resultSet.next()) {
                Shape shape = recordToEntity(resultSet);
                result.add(shape);
            }
            return result;
        });
    }

    @Override
    public List<String> getUsableShapes() {
        String query = "SELECT * FROM shape";

        return (List<String>) query(query, statement -> {
            ResultSet resultSet = statement.executeQuery(query);
            List<String> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(resultSet.getString(2));
            }
            return result;
        });
    }


    @Override
    Shape recordToEntity(ResultSet resultSet) throws SQLException {
        int shapeId = resultSet.getInt(1);
        int shape = resultSet.getInt(2);
        String name = resultSet.getString(3);
        double radius = resultSet.getDouble(4);
        double width = resultSet.getDouble(5);
        double length = resultSet.getDouble(6);
        double height = resultSet.getDouble(7);
        double volume = resultSet.getDouble(8);

        if (shape == 1) return new Sphere(shapeId, name, radius, volume);
        else if (shape == 2) return new Cylinder(shapeId, name, radius, height, volume);
        else if (shape == 3) return new Cone(shapeId, name, radius, height, volume);
        else if (shape == 4) return new Pyramid(shapeId, name, width, height, volume);
        else if (shape == 5) return new Cube(shapeId, name, width, length, height, volume);
        else return null;
    }
}