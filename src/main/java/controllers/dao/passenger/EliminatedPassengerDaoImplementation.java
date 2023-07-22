package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.IEliminatedPassengerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Passenger;

public class EliminatedPassengerDaoImplementation implements IEliminatedPassengerDao{
    
    private static final String SQL_ELIMINATED_PASSENGER = "DELETE FROM passenger WHERE idPassenger = ?";
    
    @Override
    public int eliminatedPassenger(Passenger passenger) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_ELIMINATED_PASSENGER);
            preparedStatement.setInt(1, passenger.getIdPassenger());

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
