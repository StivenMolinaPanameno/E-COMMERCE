package org.jwt.service.impl;

import org.jwt.controller.DTO.CartDTO;
import org.jwt.entities.Cart;
import org.jwt.exception.UserNotFoundException;
import org.jwt.persistence.ICartDAO;
import org.jwt.security.models.UserEntity;
import org.jwt.security.repository.UserRepository;
import org.jwt.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartDAO cartDAO;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Cart> findByUserEntityUsername(String name) {
        return cartDAO.findByUserEntityUsername(name);
    }

    @Override
    public List<Cart> findByUserEntityId(Long id) {
        return cartDAO.findByUserEntityId(id);
    }

    @Override
    public void cleanCartByUserId(Long id) {
        cartDAO.cleanCartByUserId(id);
    }

    @Override
    public Long countByUserEntityId(Long id) {
        return cartDAO.countByUserEntityId(id);
    }

    @Override
    public void addProduct(CartDTO cartDTO) throws UserNotFoundException {
        String username  = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if(userEntity.isPresent()){
            Cart cart = new Cart();
            UserEntity user = userEntity.get();
            cart.setProduct(cartDTO.getProduct());
            cart.setAmount(cartDTO.getAmount());
            cart.setUser(user);
            cartDAO.addProduct(cart);
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }


    @Override
    public void deleteCartById(Long id) {
        cartDAO.deleteCartById(id);
    }
}
