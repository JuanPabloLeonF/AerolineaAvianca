package controllers.interfaces.passenger;

import java.util.List;
import models.Passenger;

public interface IShoPassengerSameDestinationDao {
    List<Passenger> showPassengersWithSameDestination(Passenger passenger);
}
