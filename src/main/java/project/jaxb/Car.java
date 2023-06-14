package project.jaxb;

import project.dao.CarCategoryDAO;
import project.model.CarCategory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlElement
    private String brand;
    @XmlElement
    private String model;
    @XmlElement
    private int productionYear;
    @XmlElement
    private int mileage;
    @XmlElement
    private String color;
    @XmlElement
    private Location currentLocation;
    @XmlElement
    private List<Equipment> equipments;

    public Car(){}
    public Car(String brand, String model, int productionYear, int mileage, String color, Location currentLocation, List<Equipment> equipments) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.color = color;
        this.currentLocation = currentLocation;
        this.equipments = equipments;
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

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", currentLocation=" + currentLocation +
                ", equipments=" + equipments +
                '}';
    }
}
