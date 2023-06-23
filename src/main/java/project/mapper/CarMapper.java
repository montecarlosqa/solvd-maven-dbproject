package project.mapper;
import project.model.Car;
import project.model.CarCategory;

public interface CarMapper {
    Car selectCarById(int id);
    void addCar(Car car);
}
