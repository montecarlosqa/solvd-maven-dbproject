package project.dao.service;

import project.dao.model.CarCategory;
import project.dao.utils.AbstractDAO;
import project.dao.utils.ConnectionPool;
import project.dao.utils.GenericDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public List<CarCategory> findAll() {
        List<CarCategory> carCategories = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM car_category")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                CarCategory carCategory = new CarCategory();
                carCategories.add(carCategory);
            }
        } catch (SQLException e) {

        }
        return carCategories;
    }

    @Override
    public boolean save(CarCategory carCategory) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO car_category (id, category_name, rental_value) values (?, ?,?)")) {
            statement.setInt(1, carCategory.getId());
            statement.setString(2, carCategory.getCategoryName());
            statement.setDouble(3, carCategory.getRentalValue());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public boolean update(CarCategory carCategory) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE car_category SET id = ?,  category_name = ?, rental_value = ? WHERE id = ?")) {
            statement.setInt(1, carCategory.getId());
            statement.setString(2, carCategory.getCategoryName());
            statement.setDouble(3, carCategory.getRentalValue());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
        return false;
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

    public static void main(String[] args) throws SQLException{
        Properties props = new Properties();
        try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
            props.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool dbConnection = new ConnectionPool(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.password"), 1);

        CarCategoryDAO category = new CarCategoryDAO(dbConnection);
        category.save(new CarCategory(7,"secondTest",45));

    }
}
