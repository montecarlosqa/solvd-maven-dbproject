package project.dao.service;

import java.util.List;

public interface Service <T> {

    T findById(int id);
    List<T> findAll();
    boolean save(T entity);
    boolean update(T entity);
    void delete(int id);
}
