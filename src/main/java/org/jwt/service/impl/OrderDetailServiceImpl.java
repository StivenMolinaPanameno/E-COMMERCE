package org.jwt.service.impl;

import org.jwt.entities.OrderDetail;
import org.jwt.persistence.IOrderDetailDAO;
import org.jwt.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Autowired
    IOrderDetailDAO orderDetailDAO;
    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDAO.save(orderDetail);
    }
}
