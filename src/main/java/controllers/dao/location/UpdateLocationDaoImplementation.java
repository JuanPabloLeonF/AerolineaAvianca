  package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.IUpdateLocationDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Location;

public class UpdateLocationDaoImplementation implements IUpdateLocationDao {

    private static final String SQL_UPDATE_LOCATION = "UPDATE location SET country = ?, city = ? WHERE idLocation = ?";

    @Override
    public int updateLocationFields(Location location) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_LOCATION);
            preparedStatement.setString(1, location.getCountry());
            preparedStatement.setString(2, location.getCity());
            preparedStatement.setInt(3, location.getIdLocation());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return rows;
    }
}