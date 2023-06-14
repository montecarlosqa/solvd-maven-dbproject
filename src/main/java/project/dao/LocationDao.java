package project.dao;

import project.model.CarCategory;
import project.model.Location;
import project.utils.AbstractDAO;
import project.utils.ConnectionPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class LocationDao extends AbstractDAO<Location> {

    private ConnectionPool connectionPool;

    public LocationDao(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public Location findById(int id) {
        Location location = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM location WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = getLocationFromResultSet(resultSet);
            }
        } catch (SQLException e) {

        }
        return location;
    }

    @Override
    public void findAll() {
        try(Connection connection = connectionPool.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM location");
            while(resultSet.next()){
                Location location = getLocationFromResultSet(resultSet);
                System.out.print(location);
            }
        }catch (Exception e){

        }
    }

    @Override
    public void save(Location location) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO location (id, street_address, city, state, country, zip) values (?,?,?,?,?,?)")) {
            statement.setInt(1, location.getId());
            statement.setString(2, location.getStreetAddress());
            statement.setString(3, location.getCity());
            statement.setString(4, location.getState());
            statement.setString(5, location.getCountry());
            statement.setString(6, location.getZip());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(Location location) {
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE location SET street_address = ?, city = ?, state = ?, country = ?, zip =? WHERE id = ?");
            statement.setString(1, location.getStreetAddress());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getState());
            statement.setString(4, location.getCountry());
            statement.setString(5, location.getZip());
            statement.setInt(6, location.getId());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM location WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public int getCurrentLocationByCarId(int id) {
        int currentLocation = 0;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT current_location_id FROM car WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                currentLocation =resultSet.getInt("current_location_id");
            }
        } catch (SQLException e) {

        }
        return currentLocation;
    }

    private Location getLocationFromResultSet(ResultSet resultSet) throws SQLException{
        Location location = new Location();
        location.setId(resultSet.getInt("id"));
        location.setStreetAddress(resultSet.getString("street_address"));
        location.setCity(resultSet.getString("city"));
        location.setState(resultSet.getString("state"));
        location.setCountry(resultSet.getString("country"));
        location.setZip(resultSet.getString("zip"));
        return location;
    }
}
