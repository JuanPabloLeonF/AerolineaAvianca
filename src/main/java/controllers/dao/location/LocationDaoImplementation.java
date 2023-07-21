package controllers.dao.location;

import controllers.configuration.ConnectionConexion;
import controllers.interfaces.location.ILocationDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import models.Location;
import models.Passenger;

public class LocationDaoImplementation {
    
    private static final String SQL_CREATE_LOCATION = "INSERT INTO location(country, city) values(?, ?)";
    private static final String SQL_UPDATE_LOCATION = "UPDATE location SET = country = ?, city = ? WHERE idLocation = ?";
    private static final String SQL_ELIMINATED_LOCATION = "DELETE FROM location WHERE idLocation = ?";
    private static final String SQL_SHOW_ALL_LOCATION = "SELECT * FROM location";
    private static final String SQL_SEARCH_FOR_COUNTRY = "SELECT * FROM location WHERE country = ?";
    private static final String SQL_SHOW_NUMBERS_PASSENGER_GOING_COUNTRY = "SELECT * FROM passenger JOIN location ON passenger.idDestination = location.idLocation WHERE location.country = ?";
    
}
