package project.mapper;

import project.model.CarCategory;

public interface CarCategoryMapper {
    CarCategory selectCarCategoryById(int id);
    CarCategory selectCarCategoryByCategoryName(String categoryName);
    void addCarCategory(CarCategory carCategory);
}
