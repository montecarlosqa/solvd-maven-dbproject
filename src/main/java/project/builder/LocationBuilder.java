package project.builder;

import project.model.CarCategory;
import project.model.Location;

public class LocationBuilder {
    private int id;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zip;

    public LocationBuilder setId(int id){
        this.id = id;
        return this;
    }
    public LocationBuilder setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
        return this;
    }
    public LocationBuilder setCity(String city){
        this.city = city;
        return this;
    }
    public LocationBuilder setState(String state){
        this.state = state;
        return this;
    }
    public LocationBuilder setCountry(String country){
        this.country = country;
        return this;
    }
    public LocationBuilder setZip(String zip){
        this.zip = zip;
        return this;
    }
    public Location getLocation(){
        return new Location(id, streetAddress, city, state, country, zip);
    }
}
