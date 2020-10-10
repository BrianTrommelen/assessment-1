package VAT.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShapeDatabase extends Database{


    public List<Shape> getAll() {
        return super.query("SELECT * FROM shape");
    }

    @Override
    Object recordToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        //wat je wilt teruggeven van de database, opslaan als nieuw object:

        return new Shape(id, name);
    }
}