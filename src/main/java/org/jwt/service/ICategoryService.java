package org.jwt.service;

import org.jwt.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category category);
    void disableById(Long id);
    void disableByName(String name);
    Optional<Category> findByName(String name);


}
