package project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import project.builder.CarCategoryBuilder;
import project.builder.LocationBuilder;
import project.mapper.CarCategoryMapper;
import project.mapper.CarCategoryMapperJava;
import project.mapper.LocationMapper;
import project.mapper.LocationMapperJava;
import project.model.CarCategory;
import project.model.Location;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisRunner {
    public static void getIndentLine(){
        System.out.println("---------------------------");
    }
    public static void main(String[] args) throws IOException {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
            //Implementation of CarCategoryMapper interface
            CarCategoryMapper carCategoryMapper = session.getMapper(CarCategoryMapper.class);

            //Implementation of CarCategoryMapper addCarCategory method.
            carCategoryMapper.addCarCategory(new CarCategory("newCategory", 36.0));
            //Implementation of CarCategoryMapper selectCarCategoryById method.
            CarCategory carCategory1 = carCategoryMapper.selectCarCategoryById(1);
            System.out.println("Car category: \n" + carCategory1);
            //Implementation of CarCategoryMapper selectCarCategoryByName method.
            CarCategory carCategory2 = carCategoryMapper.selectCarCategoryByCategoryName("Jeep");
            System.out.println("Car category: \n" + carCategory2);
            //Implementation of CarCategoryMapper getAllCarCategories method.
            List<CarCategory> carCategoryList = carCategoryMapper.getAllCarCategories();
            System.out.println("Car category list: \n" + carCategoryList);
            //Implementation of CarCategoryMapper deleteCarCategoryById method.
            carCategoryMapper.deleteCarCategoryById(20);

            //Implementation of Builder pattern by creating CarCategoryBuilder
            CarCategoryBuilder carCategoryBuilder = new CarCategoryBuilder()
                    .setId(21)
                    .setCategoryName("newCategory")
                    .rentalValue(47);
            //Getting the CarCategory object from the builder and passing it on the CarCategory variable and using it to update the database
            CarCategory carCategory3 = carCategoryBuilder.getCarCategory();
            carCategoryMapper.updateCarCategory(carCategory3);

            getIndentLine();

            //Implementation of LocationMapper interface
            LocationMapper locationMapper = session.getMapper(LocationMapper.class);

            //Implementation of LocationMapper addLocation method.
            locationMapper.addLocation(new Location("brooklyn", "Long beach", "California", "United states", "92564"));
            //Implementation of LocationMapper selectLocationById method.
            Location location = locationMapper.selectLocationById(1);
            System.out.println("Location: \n" + location);
            //Implementation of LocationMapper getAllLocations method.
            List<Location> locationList = locationMapper.getAllLocations();
            System.out.println("Location list: \n" + locationList);
            //Implementation of LocationMapper deleteLocation method.
            locationMapper.deleteLocationById(10);

            //Implementation of Builder pattern by creating LocationBuilder
            LocationBuilder locationBuilder = new LocationBuilder()
                    .setId(8)
                    .setStreetAddress("location")
                    .setCity("city")
                    .setState("california")
                    .setCountry("united states")
                    .setZip("zip");
            //Getting the Location object from the builder and passing it on the Location variable and using it to update the database
            Location location2 = locationBuilder.getLocation();
            locationMapper.updateLocation(location2);
        }
    }
}
