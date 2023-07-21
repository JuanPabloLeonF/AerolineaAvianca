package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.IShowAllLocationDao;
import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowAllLocationDaoImplementation implements IShowAllLocationDao {
    private static final String SQL_SHOW_ALL_LOCATION = "SELECT * FROM location";

    @Override
    public List<Location> showAllLocation() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Location location = null;
        List<Location> locationsList = new ArrayList<>();

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SHOW_ALL_LOCATION);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idLocation = resultSet.getInt("idLocation");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");

                location = new Location(idLocation, country, city);
                locationsList.add(location);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closeResultSet(resultSet);
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return locationsList;
    }
}
