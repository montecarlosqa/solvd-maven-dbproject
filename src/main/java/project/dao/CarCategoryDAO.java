package project.dao;

import project.model.CarCategory;
import project.utils.AbstractDAO;
import project.utils.ConnectionPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class CarCategoryDAO extends AbstractDAO<CarCategory> {

    private ConnectionPool connectionPool;

    public CarCategoryDAO(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public CarCategory findById(int id) {
        CarCategory carCategory = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM car_category WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carCategory = getCarCategoryFromResultSet(resultSet);
            }
        } catch (SQLException e) {

        }
        return carCategory;
    }

    @Override
    public void findAll() {
        try(Connection connection = connectionPool.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car_category");
            while(resultSet.next()){
                CarCategory carCategory = getCarCategoryFromResultSet(resultSet);
                System.out.print(carCategory);
            }
        }catch (Exception e){

        }
    }

    @Override
    public void save(CarCategory carCategory) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO car_category (id, category_name, rental_value) values (?, ?,?)")) {
            statement.setInt(1, carCategory.getId());
            statement.setString(2, carCategory.getCategoryName());
            statement.setDouble(3, carCategory.getRentalValue());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(CarCategory carCategory) {
        try(Connection connection = connectionPool.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE car_category SET category_name = ?, rental_value = ? WHERE id = ?");
            statement.setString(1, carCategory.getCategoryName());
            statement.setDouble(2, carCategory.getRentalValue());
            statement.setInt(3, carCategory.getId());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM car_category WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    private CarCategory getCarCategoryFromResultSet(ResultSet resultSet) throws SQLException{
        CarCategory carCategory = new CarCategory();
        carCategory.setId(resultSet.getInt("id"));
        carCategory.setCategoryName(resultSet.getString("category_name"));
        carCategory.setRentalValue(resultSet.getDouble("rental_value"));
        return carCategory;
    }
}