package project.jaxb;

import project.dao.CarCategoryDAO;
import project.model.CarCategory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlElement
    private String brand;
    @XmlElement
    private String model;
    @XmlElement
    private Date productionDate;
    @XmlElement
    private int mileage;
    @XmlElement
    private String color;
    @XmlElement
    private Location currentLocation;
    @XmlElement
    private List<Equipment> equipments;

    public Car(){}

    public Car(String brand, String model, Date productionDate, int mileage, String color, Location currentLocation, List<Equipment> equipments) {
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
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
                ", productionDate=" + productionDate +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", currentLocation=" + currentLocation +
                ", equipments=" + equipments +
                '}';
    }
}
