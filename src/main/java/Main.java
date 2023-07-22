import controllers.dao.location.*;
import controllers.dao.passenger.*;
import controllers.interfaces.location.*;
import controllers.interfaces.passenger.*;
import models.Location;
import models.Passenger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ICreateLocationDao icreateLocationDao = new CreateLocationDaoImplementation();
        //Location location = new Location("Colombia", "Lisboa");
        //int rowsAffected = icreateLocationDao.createLocation(location);
        //System.out.println("rowsAffected = " + rowsAffected);

        //IEliminatedLocationDao iEliminatedLocationDao = new EliminatedLocationDaoImplementation();
        //Location location = new Location();
        //location.setIdLocation(2);
        //int rowsAffected2 = iEliminatedLocationDao.eliminatedLocation(location);
        //System.out.println("rowsAffected2 = " + rowsAffected2);

        //ISearchForCountryDao iSearchForCountryDao = new SearchForCountryDaoImplementation();
        //Location location = new Location();
        //location.setCountry("Francia");
        //Location find = iSearchForCountryDao.searchForCountry(location);
        //System.out.println("find = " + find);

        /*
        IShowAllLocationDao iShowAllLocationDao = new ShowAllLocationDaoImplementation();
        List<Location> locationList = iShowAllLocationDao.showAllLocation();
        for (Location location: locationList) {
            System.out.println("location = " + location);
        }
        */

        /*
        IUpdateLocationDao iupdateLocationDao = new UpdateLocationDaoImplementation();
        Location location = new Location();
        location.setIdLocation(1);
        location.setCity("San Francisco");
        location.setCountry("USA");
        int rowsAffected3 = iupdateLocationDao.updateLocationFields(location);
        System.out.println("rowsAffected3 = " + rowsAffected3);
         */

        /*
        ICreatePassengerDao iCreatePassengerDao = new CreatePassengerDaoImplementation();
        ISearchForCountryDao iSearchForCountryDao = new SearchForCountryDaoImplementation();
        Location location = new Location();
        location.setCountry("Colombia");
        Location idDestination = iSearchForCountryDao.searchForCountry(location);
        Passenger passenger = new Passenger("Juan Pablo", "1010044663", idDestination);
        int rowsAffected4 = iCreatePassengerDao.createPassenger(passenger);
        System.out.println("rowsAffected4 = " + rowsAffected4);
        */
        
        /*
        IEliminatedPassengerDao iEliminatedPassengerDao = new EliminatedPassengerDaoImplementation();
        Passenger passenger = new Passenger();
        passenger.setIdPassenger(2);
        int rowsAffected5 = iEliminatedPassengerDao.eliminatedPassenger(passenger);
        System.out.println("rowsAffected5 = " + rowsAffected5);
         */

        /*
        ISearchForIdentityDao iSearchForIdentityDao = new SearchForIdentityDaoImplementation();
        Passenger passenger = new Passenger();
        passenger.setIdentification("567");
        Passenger foundPassenger = iSearchForIdentityDao.searchForIdentity(passenger);
        System.out.println("foundPassenger = " + foundPassenger);
         */
        
        /*
        IShoPassengerSameDestinationDao iShoPassengerSameDestinationDao = new ShowPassengerSameDestinationDaoImplementation();
        ISearchForCountryDao iSearchForCountryDao = new SearchForCountryDaoImplementation();
        Passenger passenger = new Passenger();
        Location location = new Location();
        location.setCountry("USA");
        Location destination = iSearchForCountryDao.searchForCountry(location);
        passenger.setIdDestination(destination);
        List<Passenger> passengerList = iShoPassengerSameDestinationDao.showPassengersWithSameDestination(passenger);
        for (Passenger passenger1:passengerList) {
            System.out.println("passenger1 = " + passenger1);
        }
         */
        
        /*
        IShowAllPassengerDao iShowAllPassengerDao = new ShowAllPassengerDaoImplementation();
        List<Passenger> passengerList = iShowAllPassengerDao.showAllPassenger();
        for (Passenger passenger:passengerList) {
            System.out.println("passenger = " + passenger);
        }
         */

        /*
        IShowNumbersPassengersGoingCountryDao iShowNumbersPassengersGoingCountryDao = new ShowNumbersPassengersGoingCountryDaoImplementation();
        Location location = new Location();
        location.setCountry("USA");
        int rowsAffected5 = iShowNumbersPassengersGoingCountryDao.showNumbersPassengersGoingCountry(location);
        System.out.println("rowsAffected5 = " + rowsAffected5);
         */

        /*
        IUpdatePassengerDao iUpdatePassengerDao = new UpdatePassengerDaoImplementation();
        ISearchForCountryDao iSearchForCountryDao = new SearchForCountryDaoImplementation();
        Location location = new Location();
        location.setCountry("Francia");
        Location destination = iSearchForCountryDao.searchForCountry(location);
        Passenger passenger =  new Passenger();
        passenger.setIdPassenger(9);
        passenger.setName("Juan Pa");
        passenger.setIdDestination(destination);
        passenger.setIdentification("111");
        int rowsAffected6 = iUpdatePassengerDao.updatePassenger(passenger);
        System.out.println("rowsAffected6 = " + rowsAffected6);
         */
    }
}
