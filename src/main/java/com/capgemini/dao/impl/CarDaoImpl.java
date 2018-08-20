package com.capgemini.dao.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

    @Override
    public List<CarEntity> findCarByBrand(String brand) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.brand) like concat(upper(:brand), '%')", CarEntity.class);
        query.setParameter("brand", brand);

        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarByTypeAndBrand(String type, String brand) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.brand) like concat(upper(:brand), '%')" +
                        " and upper(car.type) like concat(upper(:type), '%')", CarEntity.class);
        query.setParameter("type", type);
        query.setParameter("brand", brand);

        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarsRentedBetween(Date startDate, Date endDate) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car, RentalEntity rental where rental.carId = car.id " +
                        "and rental.startDate<:endDate and rental.endDate>:startDate", CarEntity.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getResultList();
    }

    //                "select distinct(car) from CarEntity car, RentalEntity rental where rental.carId = car.id " +
    @Override
    public List<CarEntity> findCarsRentedByMoreThanTenClients() {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car join car.rentals c group by car.id" +
                " having count(distinct c.clientId.id)>10", CarEntity.class);

        return query.getResultList();
    }
}
