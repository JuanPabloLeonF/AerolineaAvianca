package controllers.interfaces.passenger;

import models.Passenger;

public interface ISearchForIdentityDao {
    Passenger searchForIdentity(Passenger passenger);
}
