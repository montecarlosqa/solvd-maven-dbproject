package project.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.PublicKey;

public class Car {
    @JsonProperty("id")
    private int id;
    @JsonProperty("car category")
    private CarCategory carCategory;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("production year")
    private int productionYear;
    @JsonProperty("mileage")
    private int mileage;
    @JsonProperty("color")
    private String color;
    @JsonProperty("current location")
    private Location currentLocation;

    public Car(){}

    public Car(int id, CarCategory carCategory, String brand, String model, int productionYear, int mileage, String color, Location currentLocation) {
        this.id = id;
        this.carCategory = carCategory;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.color = color;
        this.currentLocation = currentLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carCategory=" + carCategory +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
