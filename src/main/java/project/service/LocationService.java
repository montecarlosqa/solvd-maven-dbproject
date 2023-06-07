package project.service;

import project.model.Location;
import project.utils.GenericDAO;

public class LocationService implements Service<Location>{

    private final GenericDAO<Location> locationDao;

    public LocationService(GenericDAO<Location> locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location findById(int id) {
        return locationDao.findById(id);
    }

    @Override
    public void findAll() {
        locationDao.findAll();
    }

    @Override
    public void save(Location location) {
        locationDao.save(location);
    }

    @Override
    public void update(Location location) {
        locationDao.update(location);
    }

    @Override
    public void delete(int id) {
        locationDao.delete(id);
    }
}
