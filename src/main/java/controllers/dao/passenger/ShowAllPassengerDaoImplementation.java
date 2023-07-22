package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.IShowAllPassengerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Passenger;

public class ShowAllPassengerDaoImplementation implements IShowAllPassengerDao{
    
    private static final String SQL_SHOW_ALL_PASSENGER = "SELECT * FROM passenger";
    private static final String SQL_GET_LOCATION_BY_ID = "SELECT * FROM location WHERE idLocation = ?";
    
    @Override
    public List<Passenger> showAllPassenger() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Passenger passenger = null;
        List<Passenger> passengerList = new ArrayList<Passenger>();

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SHOW_ALL_PASSENGER);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPassenger = resultSet.getInt("idPassenger");
                String name = resultSet.getString("name");
                String identification = resultSet.getString("identification");
                int idDestination = resultSet.getInt("idDestination");

                Location destination = getLocationById(idDestination);
                passenger = new Passenger(idPassenger, name, identification, destination);
                passengerList.add(passenger);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closeResultSet(resultSet);
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return passengerList;
    }
    
    private Location getLocationById(int idDestination) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Location location = null;
        
        try {
            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_LOCATION_BY_ID);
            preparedStatement.setInt(1, idDestination);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int idLocation = resultSet.getInt("idLocation");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                
                location = new Location(idLocation, country, city);
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
