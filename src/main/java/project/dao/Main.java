package project.dao;

import project.model.CarCategory;
import project.utils.ConnectionPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
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

//        CarCategoryDAO category = new CarCategoryDAO(dbConnection);
//        category.update(new CarCategory(6,"Pick up", 35.99));

        LocationDao location = new LocationDao(dbConnection);
        System.out.println(location.findById(1));

    }
}
