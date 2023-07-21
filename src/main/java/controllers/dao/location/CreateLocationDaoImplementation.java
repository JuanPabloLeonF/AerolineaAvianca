package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.ICreateLocationDao;
import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateLocationDaoImplementation implements ICreateLocationDao {

    private static final String SQL_CREATE_LOCATION = "INSERT INTO location(country, city ) values(?, ?)";
    @Override
    public int createLocation(Location location) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_LOCATION);
            preparedStatement.setString(1, location.getCountry());
            preparedStatement.setString(2, location.getCity());

            rows =  preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return rows;
    }
}
