package org.jwt.service;

import org.jwt.entities.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> findByUser_Username(String username);
    Optional<Order> findFirstByUserUsernameOrderByDateDesc(String username);
    Optional<Order> findLastActiveOrderByUsername(String username);
    void disableOrderById( Long orderId);
    List<Order> findAll();
    void createOrder(String Username);
    List<Order> findActiveOrdersByUsername(String username);
}
