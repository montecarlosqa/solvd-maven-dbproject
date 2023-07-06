package project.builder;

import project.model.CarCategory;

public class CarCategoryBuilder {
    private int id;
    private String categoryName;
    private double rentalValue;

    public CarCategoryBuilder setId(int id){
        this.id = id;
        return this;
    }
    public CarCategoryBuilder setCategoryName(String categoryName){
        this.categoryName = categoryName;
        return this;
    }
    public CarCategoryBuilder rentalValue(double rentalValue){
        this.rentalValue = rentalValue;
        return this;
    }
    public CarCategory getCarCategory(){
        return new CarCategory(id, categoryName, rentalValue);
    }
}
