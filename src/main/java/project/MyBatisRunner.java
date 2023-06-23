package project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import project.mapper.CarCategoryMapper;
import project.mapper.CarCategoryMapperJava;
import project.mapper.LocationMapper;
import project.mapper.LocationMapperJava;
import project.model.CarCategory;
import project.model.Location;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisRunner {
    public static void main(String[] args) throws IOException {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);

            //Implementation of CarCategoryMapper interface
            CarCategoryMapper carCategoryMapper = session.getMapper(CarCategoryMapper.class);
            //Implementation of CarCategoryMapper add method.
            carCategoryMapper.addCarCategory(new CarCategory("newCategory", 36.0));
            //Implementation of CarCategoryMapper selectCarCategoryById
            CarCategory carCategory1 = carCategoryMapper.selectCarCategoryById(1);
            System.out.println("Car category: \n" + carCategory1);
            //Implementation of CarCategoryMapper selectCarCategoryByName
            CarCategory carCategory2 = carCategoryMapper.selectCarCategoryByCategoryName("Compact");
            System.out.println("Car category: \n" + carCategory2);

            //Implementation of CarCategoryMapperJava interface
            CarCategoryMapperJava carCategoryMapperJava = session.getMapper(CarCategoryMapperJava.class);
            //Implementation of CarCategoryMapperJava selectCarCategoryById
            CarCategory carCategory3 = carCategoryMapperJava.selectCarCategoryById(1);
            System.out.println("Car Category: \n" + carCategory3);

            System.out.println("-----------------------------");

            //Implementation of LocationMapper interface
            LocationMapper locationMapper = session.getMapper(LocationMapper.class);
            //Implementation of LocationMapper add method.
            locationMapper.addLocation(new Location("brooklyn", "Long beach", "California", "United states", "92564"));
            //Implementation of LocationMapper selectLocationById
            Location location = locationMapper.selectLocationById(1);
            System.out.println("Location: \n" + location);
            //Implementation of LocationMapperJava interface
            LocationMapperJava locationMapperJava = session.getMapper(LocationMapperJava.class);
            //Implementation of LocationJava selectLocationById
            Location location2 = locationMapperJava.selectLocationById(1);
            System.out.println("Location: \n" + location2);
        }


    }
}
