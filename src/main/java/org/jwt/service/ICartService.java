package org.jwt.service;

import org.jwt.controller.DTO.CartDTO;
import org.jwt.entities.Cart;
import org.jwt.exception.UserNotFoundException;

import java.util.List;

public interface ICartService {
    List<Cart> findByUserEntityUsername(String name);
    List<Cart> findByUserEntityId(Long id);
    void cleanCartByUserId(Long id);
    Long countByUserEntityId(Long id);
    void addProduct(CartDTO cart) throws UserNotFoundException;
    void deleteCartById(Long id);
}
