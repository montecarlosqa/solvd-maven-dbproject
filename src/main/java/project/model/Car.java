package project.model;

public class Car {

    private int id;
    private CarCategory carCategoryId;
    private String brand;
    private String model;
    private int productionYear;
    private int mileage;
    private String color;
    private Location currentLocation;;

    public Car(CarCategory carCategoryId, String brand, String model, int productionYear, int mileage, String color, Location currentLocation) {
        this.carCategoryId = carCategoryId;
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

    public CarCategory getCarCategoryId() {
        return carCategoryId;
    }

    public void setCarCategoryId(CarCategory carCategoryId) {
        this.carCategoryId = carCategoryId;
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
                ", carCategoryId=" + carCategoryId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
