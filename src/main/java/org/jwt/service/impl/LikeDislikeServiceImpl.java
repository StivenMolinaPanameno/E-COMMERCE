package org.jwt.service.impl;

import org.apache.catalina.User;
import org.jwt.entities.LikeDislike;
import org.jwt.entities.Product;
import org.jwt.persistence.LikeDislikeDAO;
import org.jwt.security.models.UserEntity;
import org.jwt.security.repository.UserRepository;
import org.jwt.service.ILikeDislikeService;
import org.jwt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class LikeDislikeServiceImpl implements ILikeDislikeService {
    @Autowired
    LikeDislikeDAO likeDislikeDAO;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IProductService productService;
    @Override
    public void save(String vote, Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        UserEntity user = userOptional.get();

        Long idUser = user.getId();

        Optional<Product> productOptional = productService.findById(id);

        boolean existUser = likeDislikeDAO.existsByUserId(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            Long idProduct = product.getId();

            boolean existProduct;

            existProduct = likeDislikeDAO.existsByProductId(idProduct);

            if(existProduct && existUser){
                Optional<LikeDislike> likeDislikeOptional = likeDislikeDAO.findByUser_IdAndProduct_Id(idUser, idProduct);
                if(likeDislikeOptional.isPresent()){
                    LikeDislike likeDislike = likeDislikeOptional.get();
                    LikeDislike likeOrDislike = LikeDislike.builder()
                            .id(likeDislike.getId())
                            .product(likeDislike.getProduct())
                            .user(user)
                            .vote(vote)
                            .build();
                    likeDislikeDAO.save(likeOrDislike);
                }

            }else{
                LikeDislike likeDislike = LikeDislike.builder()
                        .vote(vote)
                        .user(user)
                        .product(product)
                        .build();
                likeDislikeDAO.save(likeDislike);
            }
        }


    }

}
