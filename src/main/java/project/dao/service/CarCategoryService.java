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
    public List<CarCategory> findAll() {
        return carCategoryDAO.findAll();
    }

    @Override
    public boolean save(CarCategory carCategory) {

        return carCategoryDAO.save(carCategory);
    }

    @Override
    public boolean update(CarCategory entity) {
        return false;
    }

    @Override
    public void delete(int id) {
        carCategoryDAO.delete(id);
    }
}
