package org.jwt.persistence.impl;

import jakarta.transaction.Transactional;
import org.jwt.entities.Product;
import org.jwt.persistence.IProductDAO;
import org.jwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    ProductRepository repository;
    private String name;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return repository.findByCategoryName(category);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return repository.findByName(name);
    }
    @Transactional
    @Override
    public void disableById(Long id) {
        repository.disableById(id);
    }
    @Transactional
    @Override
    public void disableByName(String name) {
        disableByName(name);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
