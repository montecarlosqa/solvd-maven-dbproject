package project.mapper;
import project.model.Location;

public interface LocationMapper {

    Location selectLocationById(int id);
    void addLocation(Location location);
}
