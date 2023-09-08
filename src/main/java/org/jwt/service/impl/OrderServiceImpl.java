package org.jwt.service.impl;

import org.aspectj.weaver.ast.Or;
import org.jwt.entities.Order;
import org.jwt.entities.OrderDetail;
import org.jwt.persistence.IOrderDAO;
import org.jwt.security.models.UserEntity;
import org.jwt.entities.Cart;
import org.jwt.security.repository.UserRepository;
import org.jwt.service.ICartService;
import org.jwt.service.IOrderDetailService;
import org.jwt.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
   @Autowired
    IOrderDAO orderDAO;
   @Autowired
    UserRepository userRepository;
   @Autowired
    ICartService cartService;
   @Autowired
    IOrderDetailService orderDetailService;


    @Override
    public List<Order> findByUser_Username(String username) {
        return null;
    }

    @Override
    public Optional<Order> findFirstByUserUsernameOrderByDateDesc(String username) {
        return orderDAO.findFirstByUserUsernameOrderByDateDesc(username);
    }

    @Override
    public Optional<Order> findLastActiveOrderByUsername(String username) {
        return orderDAO.findLastActiveOrderByUsername(username);
    }

    @Override
    public void disableOrderById(Long orderId) {
        orderDAO.disableOrderById(orderId);

    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public void createOrder(String username) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if(userEntity.isPresent()){
            UserEntity user = userEntity.get();
            List<Cart> shoppingCartList = cartService.findByUserEntityUsername(username);
            DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.DOWN);

            BigDecimal total = shoppingCartList.stream()
                    .map(shoppingCartItem -> {
                        BigDecimal price = shoppingCartItem.getProduct().getPrice();
                        BigDecimal amount = BigDecimal.valueOf(shoppingCartItem.getAmount());
                        return price.multiply(amount);
                    })
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            Order order = new Order(total, new Date(), user, true);
            Order orderSave = orderDAO.save(order);

            for(Cart cart: shoppingCartList){
                OrderDetail detail = new OrderDetail();
                detail.setOrder(orderSave);
                detail.setProduct(cart.getProduct());
                detail.setAmount(cart.getAmount());
                orderDetailService.save(detail);

            }

            cartService.cleanCartByUserId(user.getId());
        }

    }

    @Override
    public List<Order> findActiveOrdersByUsername(String username) {
        return orderDAO.findActiveOrdersByUsername(username);
    }
}
