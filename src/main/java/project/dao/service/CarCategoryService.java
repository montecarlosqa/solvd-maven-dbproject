package project.dao.service;

import project.dao.model.CarCategory;
import project.dao.utils.GenericDAO;

import java.util.List;

public class CarCategoryService implements Service<CarCategory>{
    private final GenericDAO<CarCategory> carCategoryDAO;

    public CarCategoryService(GenericDAO<CarCategory> carCategoryDAO) {
        this.carCategoryDAO = carCategoryDAO;
    }

    @Override
    public CarCategory findById(int id) {
        return carCategoryDAO.findById(id);
    }

    @Override
    public void findAll() {
        carCategoryDAO.findAll();
    }

    @Override
    public void save(CarCategory carCategory) {
        carCategoryDAO.save(carCategory);
    }

    @Override
    public void update(CarCategory carCategory) {
        carCategoryDAO.update(carCategory);
    }

    @Override
    public void delete(int id) {
        carCategoryDAO.delete(id);
    }
}
