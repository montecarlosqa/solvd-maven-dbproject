package project.dao.service;

import java.util.List;

public interface Service <T> {

    T findById(int id);
    void findAll();
    void save(T entity);
    void update(T entity);
    void delete(int id);
}
