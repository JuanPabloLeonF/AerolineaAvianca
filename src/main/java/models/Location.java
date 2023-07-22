package models;

public class Location {

    private int idLocation;
    private String country;
    private String city;

    public Location() {
    }

    public Location(int idLocation, String country, String city) {
        this.idLocation = idLocation;
        this.country = country;
        this.city = city;
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Location(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" + "idLocation=" + idLocation + ", country=" + country + ", city=" + city + '}';
    }
}
