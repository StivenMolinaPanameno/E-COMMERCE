package org.jwt.persistence.impl;

import org.jwt.entities.Cart;
import org.jwt.persistence.ICartDAO;
import org.jwt.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CartDAOImpl implements ICartDAO {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> findByUserEntityUsername(String name) {
        return cartRepository.findByUser_Username(name);
    }

    @Override
    public List<Cart> findByUserEntityId(Long id) {
        return cartRepository.findByUser_Id(id);
    }

    @Override
    public void cleanCartByUserId(Long id) {
        cartRepository.deleteByUser_Id(id);
    }

    @Override
    public Long countByUserEntityId(Long id) {
        return cartRepository.countByUser_Id(id);
    }

    @Override
    public void addProduct(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }
}
