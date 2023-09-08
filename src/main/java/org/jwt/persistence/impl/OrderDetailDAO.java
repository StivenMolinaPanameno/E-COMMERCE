package org.jwt.persistence.impl;

import jakarta.transaction.Transactional;
import org.jwt.persistence.IOrderDetailDAO;
import org.jwt.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailDAO implements IOrderDetailDAO {

   @Autowired
    OrderDetailRepository orderDetailRepository;

   @Transactional
    @Override
    public void save(org.jwt.entities.OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}
