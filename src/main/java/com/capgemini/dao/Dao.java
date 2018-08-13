package com.capgemini.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, K extends Serializable> {
    T save (T entity);

    T getOne(K id);

    T findOne(K id);

    List<T> findAll();
}
