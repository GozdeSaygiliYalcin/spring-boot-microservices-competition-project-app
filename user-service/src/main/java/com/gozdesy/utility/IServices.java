package com.gozdesy.utility;

import java.util.List;
import java.util.Optional;

public interface IServices<T, ID> {

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();


}
