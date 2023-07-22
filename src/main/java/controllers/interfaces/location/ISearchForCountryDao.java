package controllers.interfaces.location;

import models.Location;

public interface ISearchForCountryDao {
    Location searchForCountry(Location location);
}
