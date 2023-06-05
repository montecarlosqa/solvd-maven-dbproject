package project.dao.utils;

import java.util.List;

public interface GenericDAO<T> {
    T findById(int id);
    List<T> findAll();
    boolean save(T entity);
    boolean update(T entity);
    void delete(int id);

}