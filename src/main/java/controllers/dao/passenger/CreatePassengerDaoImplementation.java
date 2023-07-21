package controllers.dao.passenger;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.passenger.ICreatePassengerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Passenger;

public class CreatePassengerDaoImplementation implements ICreatePassengerDao{
    
    private static final String SQL_CREATE_PASSENGER = "INSERT INTO passenger(name, identification, idDestination) values(?, ? , ?)";

    @Override
    public int createPassenger(Passenger passenger) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionConexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_PASSENGER);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getIdentification());
            preparedStatement.setInt(3, passenger.getIdDestination().getIdLocation());

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
