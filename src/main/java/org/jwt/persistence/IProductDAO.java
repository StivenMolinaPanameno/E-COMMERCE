package org.jwt.persistence;

import org.jwt.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    List<Product> findAll();
    List<Product> findByCategory(String category);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    void disableById(Long id);
    void disableByName(String name);
    void save(Product product);
    void delete(Long id);

}
