package project.utils;

import java.util.List;

public interface GenericDAO<T> {
    T findById(int id);
    void findAll();
    void save(T entity);
    void update(T entity);
    void delete(int id);

}
