package com.company.GorelikGY.repos;

import com.company.GorelikGY.domain.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<OrdersEntity, Integer> {
    List<OrdersEntity> findOrdersEntitiesByStreet(String street);
}
