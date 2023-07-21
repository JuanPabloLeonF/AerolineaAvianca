package controllers.interfaces.location;

import models.Location;

public interface IUpdateLocationDao {
    int updateLocationFields(Location location);
}