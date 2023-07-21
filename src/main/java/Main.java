
import controllers.dao.PassengerDaoImplementation;
import java.util.List;
import models.Location;
import models.Passenger;

public class Main {

    public static void main(String[] args) {
        
         // Crear una instancia del DAO
        PassengerDaoImplementation passengerDao = new PassengerDaoImplementation();
        Passenger newPassenger = new Passenger("Fran", "567", new Location(1, "Francia", "Paris"));
        passengerDao.createPassenger(newPassenger);

        // Obtener un pasajero de la base de datos para usar su destino en la búsqueda
        // Asegúrate de que haya al menos un pasajero con el destino que deseas probar.
        List<Passenger> allPassengers = passengerDao.showAllPassenger();
        Passenger passengerWithDestination = allPassengers.get(0);

        // Prueba del método showPassengersWithSameDestination
        System.out.println("\nListado de pasajeros con el mismo destino:");
        List<Passenger> passengersWithSameDestination = passengerDao.showPassengersWithSameDestination(passengerWithDestination);
        for (Passenger passenger : passengersWithSameDestination) {
            System.out.println(passenger);
        }
        
        // Prueba del método showAllPassenger
        System.out.println("\nListado de todos los pasajeros:");
        for (Passenger passenger : passengerDao.showAllPassenger()) {
            System.out.println(passenger);
        }
    }
}
