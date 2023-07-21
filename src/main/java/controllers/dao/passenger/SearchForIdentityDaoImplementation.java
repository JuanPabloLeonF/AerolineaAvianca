package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.ISearchForIdentityDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Location;
import models.Passenger;

public class SearchForIdentityDaoImplementation implements ISearchForIdentityDao{
    private static final String SQL_SEARCH_FOR_IDENTITY = "SELECT p.idPassenger, p.name, p.identification, l.idLocation, l.country, l.city FROM passenger p JOIN location l ON p.idDestination = l.idLocation WHERE p.identification = ?";

    @Override
    public Passenger searchForIdentity(Passenger passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SEARCH_FOR_IDENTITY);
            preparedStatement.setString(1, passenger.getIdentification());
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                int idPassenger = resultSet.getInt("idPassenger");
                String name = resultSet.getString("name");
                int idDestination = resultSet.getInt("idLocation");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                Location destination = new Location(idDestination, country, city);

                passenger.setIdPassenger(idPassenger);
                passenger.setName(name);
                passenger.setIdDestination(destination);
                
            } else {
                throw new SQLException("No se encontro ningun pasajero con la identificacion proporcionada.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closeResultSet(resultSet);
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return passenger;
    }
}
