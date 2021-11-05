package io.tjohander.tacocloud.repository;

import io.tjohander.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByZip(String zipCode);
}
