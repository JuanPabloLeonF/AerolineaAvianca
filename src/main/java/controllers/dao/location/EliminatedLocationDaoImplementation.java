package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.IEliminatedLocationDao;
import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminatedLocationDaoImplementation implements IEliminatedLocationDao {

    private static final String SQL_ELIMINATED_LOCATION = "DELETE FROM location WHERE idLocation = ?";

    @Override
    public int eliminatedLocation(Location idLocation) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_ELIMINATED_LOCATION);
            preparedStatement.setInt(1, idLocation.getIdLocation());

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