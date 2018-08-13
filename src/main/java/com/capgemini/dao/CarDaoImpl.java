package com.capgemini.dao;

import com.capgemini.entity.CarEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

    @Override
    public List<CarEntity> findCarByBrand(String brand) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from cars where upper(cars.brand) like concat(upper(:brand), '%')", CarEntity.class);
        query.setParameter("brand", brand);

        return query.getResultList();
    }
}
