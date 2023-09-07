package org.jwt.persistence.impl;

import jakarta.transaction.Transactional;
import org.jwt.entities.Category;
import org.jwt.persistence.ICategoryDAO;
import org.jwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CatetoryDAOImpl implements ICategoryDAO {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void disableById(Long id) {
        categoryRepository.disableCategoryById(id);
    }

    @Transactional
    @Override
    public void disableByName(String name) {
        categoryRepository.disableCategoryByName(name);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
