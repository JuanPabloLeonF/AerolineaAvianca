package controllers.interfaces;

import java.util.List;
import models.Location;
import models.Passenger;

public interface ILocationDao {

    int createLocation(Location location);
    void updateLocation(Location idLocation);
    void eliminatedLocation(Location idLocation);
    List<Location> showAllLocation();
    Location searchForCountry(Location location);
    int showNumbersPassengersGoingCountry(Location location ,Passenger passenger);
}
