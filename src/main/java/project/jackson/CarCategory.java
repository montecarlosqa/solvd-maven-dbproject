package project.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarCategory {
    @JsonProperty("id")
    private int id;
    @JsonProperty("category name")
    private String categoryName;
    @JsonProperty("rental value")
    private double rentalValue;

    public CarCategory(){};

    public CarCategory(int id, String categoryName, double rentalValue) {
        this.id = id;
        this.categoryName = categoryName;
        this.rentalValue = rentalValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(double rentalValue) {
        this.rentalValue = rentalValue;
    }

    @Override
    public String toString() {
        return "CarCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", rentalValue=" + rentalValue +
                '}';
    }
}
