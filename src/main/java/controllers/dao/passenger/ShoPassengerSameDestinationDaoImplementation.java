package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.IShoPassengerSameDestinationDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Passenger;

public class ShoPassengerSameDestinationDaoImplementation implements IShoPassengerSameDestinationDao {

    private static final String SQL_SHOW_PASSENGER_WITH_SAME_DESTINATION = "SELECT p.idPassenger, p.name, p.identification, l.idLocation, l.country, l.city  FROM passenger p JOIN location l  ON  p.idDestination = l.idLocation where p.idDestination = ?";

    @Override
    public List<Passenger> showPassengersWithSameDestination(Passenger passenger) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Passenger> passengerList = new ArrayList<Passenger>();

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SHOW_PASSENGER_WITH_SAME_DESTINATION);
            preparedStatement.setInt(1, passenger.getIdDestination().getIdLocation());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPassenger = resultSet.getInt("idPassenger");
                String name = resultSet.getString("name");
                String identification = resultSet.getString("identification");
                int idDestination = resultSet.getInt("idLocation");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                Location destination = new Location(idDestination, country, city);

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
}
