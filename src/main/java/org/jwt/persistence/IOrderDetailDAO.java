package org.jwt.persistence;

import org.jwt.entities.OrderDetail;

public interface IOrderDetailDAO {
    void save(OrderDetail orderDetail);
}
