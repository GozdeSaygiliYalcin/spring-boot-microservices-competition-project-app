package com.gozdesy.utility;

import java.util.List;

public interface IServices<T, ID> {

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    T findById(ID id);
    List<T> findAll();


}
