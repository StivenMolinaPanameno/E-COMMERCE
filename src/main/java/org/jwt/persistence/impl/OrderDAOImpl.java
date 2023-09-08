package org.jwt.persistence.impl;

import jakarta.transaction.Transactional;
import org.jwt.entities.Order;
import org.jwt.entities.Product;
import org.jwt.persistence.IOrderDAO;
import org.jwt.repository.OrderRepository;
import org.jwt.security.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDAOImpl implements IOrderDAO {
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findByUser_Username(String username) {
        return orderRepository.findByUser_Username(username);
    }

    @Override
    public Optional<Order> findFirstByUserUsernameOrderByDateDesc(String username) {
        return orderRepository.findFirstByUserUsernameOrderByDateDesc(username);
    }

    @Override
    public Optional<Order> findLastActiveOrderByUsername(String username) {
        return orderRepository.findLastActiveOrderByUsername(username);
    }

    @Transactional
    @Override
    public void disableOrderById(Long orderId) {
        orderRepository.disableOrderById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findActiveOrdersByUsername(String username) {
        return orderRepository.findActiveOrdersByUsername(username);
    }


}
