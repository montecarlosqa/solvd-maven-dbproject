package project.mapper;

import project.model.CarCategory;

import java.util.List;

public interface CarCategoryMapper {
    CarCategory selectCarCategoryById(int id);
    List<CarCategory> getAllCarCategories();
    CarCategory selectCarCategoryByCategoryName(String categoryName);
    void addCarCategory(CarCategory carCategory);
    void updateCarCategory(CarCategory carCategory);
    void deleteCarCategoryById(int id);
}
