package controllers.interfaces;

import java.util.List;
import models.Passenger;

public interface IPassengerDao {
    int createPassenger(Passenger passenger);
    int updatePassenger(Passenger passenger);
    int eliminatedPassenger(Passenger passenger);
    List<Passenger> showAllPassenger();
    Passenger searchForIdentity(Passenger passenger);
    List<Passenger> showPassengersWithSameDestination(Passenger passenger);
}
