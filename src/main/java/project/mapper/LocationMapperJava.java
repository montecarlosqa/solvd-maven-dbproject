package project.mapper;

import org.apache.ibatis.annotations.Select;
import project.model.Location;

public interface LocationMapperJava {
    @Select("select id, street_address AS streetAddress, city AS city, state as state, country AS country, zip AS zip from location where id = #{id}")
    Location selectLocationById(int id);
}
