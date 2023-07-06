package project.mapper;
import project.model.CarCategory;
import project.model.Location;

import java.util.List;

public interface LocationMapper {

    Location selectLocationById(int id);
    List<Location> getAllLocations();
    void addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int id);
}
