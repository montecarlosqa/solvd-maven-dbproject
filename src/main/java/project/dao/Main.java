package project.dao;

import project.model.CarCategory;
import project.model.Location;
import project.utils.ConnectionPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void getIndentLine(){
        System.out.println("---------------------");
    }
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
            props.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool dbConnection = new ConnectionPool(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.password"), 1);

        //Creation of car category dao object and implementing all the CRUD operations
        CarCategoryDAO carCategoryDAO = new CarCategoryDAO(dbConnection);
        carCategoryDAO.findAll();
        carCategoryDAO.findById(1);
        carCategoryDAO.update(new CarCategory(6,"Pick up", 33.99));
        carCategoryDAO.save(new CarCategory(7,"Test", 35.99));
        carCategoryDAO.delete(13);
        getIndentLine();
        //Creation of location dao object and implementing all the CRUD operations
        LocationDao locationDao = new LocationDao(dbConnection);
        locationDao.findAll();
        locationDao.findById(1);
        locationDao.update(new Location(8,"Location","city","state","country","zip"));
        locationDao.save(new Location(9,"newLocation","city","state","country","zip"));
        locationDao.delete(9);


    }
}
