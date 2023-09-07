package org.jwt.repository;

import org.jwt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName);
    Optional<Product> findByName(String nameProduct);
    @Modifying
    @Query("UPDATE Product u SET u.enabled = false WHERE u.id = :productId")
    void disableById(@Param("productId") Long id);
    @Modifying
    @Query("UPDATE Product u SET u.enabled = false WHERE u.name = :productName")
    void disableByName(@Param("productName") String productName);
}
