package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.ISearchForCountryDao;
import models.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchForCountryDaoImplementation implements ISearchForCountryDao {
    private static final String SQL_SEARCH_FOR_COUNTRY = "SELECT * FROM location WHERE country = ?";

    @Override
    public Location searchForCountry(Location location) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SEARCH_FOR_COUNTRY);
            preparedStatement.setString(1, location.getCountry());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int idLocation = resultSet.getInt("idLocation");
                String city = resultSet.getString("city");

                location.setIdLocation(idLocation);
                location.setCity(city);

            } else {
                throw new SQLException("No se encontro ninguna localizacion con la proporcionada.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closeResultSet(resultSet);
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return location;
    }
}
