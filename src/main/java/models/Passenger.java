package models;

public class Passenger {

    private int idPassenger;
    private String name;
    private String identification;
    private Location idDestination;

    public Passenger() {
    }

    public Passenger(String name, String identification, Location idDestination) {
        this.name = name;
        this.identification = identification;
        this.idDestination = idDestination;
    }

    public Passenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Passenger(int idPassenger, String name, String identification, Location idDestination) {
        this.idPassenger = idPassenger;
        this.name = name;
        this.identification = identification;
        this.idDestination = idDestination;
    }

    public Passenger(String identification) {
        this.identification = identification;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Location getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Location idDestination) {
        this.idDestination = idDestination;
    }

    @Override
    public String toString() {
        return "Passenger{" + "idPassenger=" + idPassenger + ", name=" + name + ", identification=" + identification + ", idDestination=" + idDestination + '}';
    }
}
