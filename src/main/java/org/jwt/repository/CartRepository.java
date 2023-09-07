package org.jwt.repository;
import java.util.*;
import org.jwt.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_Username(String name);
    List<Cart> findByUser_Id(Long id);
    void deleteByUser_Id(Long id);
    Long countByUser_Id(Long id);
}
