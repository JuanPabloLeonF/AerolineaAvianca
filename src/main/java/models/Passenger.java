package models;

public class Passenger {

    private int idPassenger;
    private String name;
    private String identification;
    private String destination;

    public Passenger() {
    }

    public Passenger(String name, String identification, String destination) {
        this.name = name;
        this.identification = identification;
        this.destination = destination;
    }

    public Passenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Passenger(int idPassenger, String name, String identification, String destination) {
        this.idPassenger = idPassenger;
        this.name = name;
        this.identification = identification;
        this.destination = destination;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
