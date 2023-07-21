package controllers.dao;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.IPassengerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Passenger;

public class PassengerDaoImplementation implements IPassengerDao {

    private static final String SQL_CREATE_PASSENGER = "INSERT INTO passenger(name, identification, idDestination) values(?, ? , ?)";
    private static final String SQL_UPDATE_PASSENGER = "UPDATE passenger SET = name = ?, identification = ?, idDestination = ? WHERE idPassenger = ?";
    private static final String SQL_ELIMINATED_PASSENGER = "DELETE FROM passenger WHERE idPassenger = ?";
    private static final String SQL_SHOW_ALL_PASSENGER = "SELECT * FROM passenger";
    private static final String SQL_SEARCH_FOR_IDENTITY = "SELECT p.idPassenger, p.name, p.identification, l.idLocation, l.country, l.city FROM passenger p JOIN location l ON p.idDestination = l.idLocation WHERE p.identification = ?";
    private static final String SQL_SHOW_PASSENGER_WITH_SAME_DESTINATION = "SELECT p.idPassenger, p.name, p.identification, l.idLocation, l.country, l.city  FROM passenger p JOIN location l  ON  p.idDestination = l.idLocation where p.idDestination = ?";
    private static final String SQL_GET_LOCATION_BY_ID = "SELECT * FROM location WHERE idLocation = ?";
    
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
            preparedStatement.setInt(3, passenger.getIdDestination().getIdLocation());
            preparedStatement.setInt(4, passenger.getIdPassenger());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            ConnectionConexion.closePreparedStatement(preparedStatement);
            ConnectionConexion.closeConnection(connection);
        }

        return rows;
    }

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
                String identification = resultSet.getString("identification");
                int idDestination = resultSet.getInt("idLocation");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                Location destination = new Location(idDestination, country, city);
                
                passenger = new Passenger();
                passenger.setIdPassenger(idPassenger);
                passenger.setName(name);
                passenger.setIdentification(identification);
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
