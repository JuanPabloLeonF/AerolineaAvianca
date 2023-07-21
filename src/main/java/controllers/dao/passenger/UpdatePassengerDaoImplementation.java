package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.IUpdatePassengerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Passenger;

public class UpdatePassengerDaoImplementation implements IUpdatePassengerDao{
    
    private static final String SQL_UPDATE_PASSENGER = "UPDATE passenger SET name = ?, identification = ? WHERE idPassenger = ?";

    @Override
    public int updatePassenger(Passenger passenger) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_PASSENGER);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getIdentification());
            preparedStatement.setInt(3, passenger.getIdPassenger());

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
