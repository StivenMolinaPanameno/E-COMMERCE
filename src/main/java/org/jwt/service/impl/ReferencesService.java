package org.jwt.service.impl;

import org.jwt.controller.DTO.ReferenceDTO;
import org.jwt.entities.Product;
import org.jwt.entities.References;
import org.jwt.exception.ProductNotFoundException;
import org.jwt.persistence.IReferenceDAO;
import org.jwt.security.models.UserEntity;
import org.jwt.security.repository.UserRepository;
import org.jwt.service.IProductService;
import org.jwt.service.IReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferencesService implements IReferenceService {

    @Autowired
    IReferenceDAO referenceDAO;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IProductService productService;
    @Override
    public List<References> findAll() {
        return referenceDAO.findAll();
    }

    @Override
    public void save(ReferenceDTO references, Long id) throws ProductNotFoundException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserEntity> user = userRepository.findByUsername(username);
        Optional<Product> productOptional = productService.findById(id);
        if (user.isPresent() && productOptional.isPresent()) {
            UserEntity userEntity = user.get();
            Product product = productOptional.get();
            References reference = References.builder()
                    .reference(references.getReference())
                    .product(product)
                    .user(userEntity)
                    .build();
            referenceDAO.save(reference);
        } else {
            throw new ProductNotFoundException("Product not found"); // Lanza una excepción en lugar de devolver un ResponseEntity
        }
    }

    @Override
    public List<References> findByProduct_Id(Long id) {
        return referenceDAO.findByProduct_Id(id);
    }
}
