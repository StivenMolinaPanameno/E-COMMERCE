package org.jwt.persistence;

import org.jwt.entities.Cart;

import java.util.List;

public interface ICartDAO {
    List<Cart> findByUserEntityUsername(String name);
    List<Cart> findByUserEntityId(Long id);
    void cleanCartByUserId(Long id);
    Long countByUserEntityId(Long id);
    void addProduct(Cart cart);
    void deleteCartById(Long id);

}
