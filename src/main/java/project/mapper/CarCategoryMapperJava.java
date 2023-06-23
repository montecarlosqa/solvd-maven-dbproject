package project.mapper;

import org.apache.ibatis.annotations.Select;
import project.model.CarCategory;

public interface CarCategoryMapperJava {
    @Select("select id, category_name as categoryName, rental_value as rentalValue from car_category where id = #{id}")
    CarCategory selectCarCategoryById(int id);
}
