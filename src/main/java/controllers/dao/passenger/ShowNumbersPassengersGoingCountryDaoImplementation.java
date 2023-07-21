package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.IShowNumbersPassengersGoingCountryDao;
import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowNumbersPassengersGoingCountryDaoImplementation implements IShowNumbersPassengersGoingCountryDao {
    private static final String SQL_SHOW_PASSENGER_GOING_SAME_COUNTRY = "SELECT COUNT(*) FROM passenger p JOIN location l ON p.idDestination = l.idLocation WHERE l.country = ?";

    @Override
    public int showNumbersPassengersGoingCountry(Location location) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int numbersPassenger = 0;

        try {
            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SHOW_PASSENGER_GOING_SAME_COUNTRY);
            preparedStatement.setString(1, location.getCountry());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                numbersPassenger = resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionConexion.closeResultSet(resultSet);
            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return numbersPassenger;
    }
}