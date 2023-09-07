package org.jwt.service.impl;

import org.jwt.entities.Product;
import org.jwt.persistence.IProductDAO;
import org.jwt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productDAO.findByCategory(category);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public void disableById(Long id) {
        productDAO.disableById(id);
    }

    @Override
    public void disableByName(String name) {
        productDAO.disableByName(name);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void delete(Long id) {
        productDAO.delete(id);
    }
}
