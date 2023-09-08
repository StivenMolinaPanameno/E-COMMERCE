package org.jwt.persistence;

import org.jwt.entities.ProductDetail;

import java.util.Optional;

public interface IProductDetailDAO {
    Optional<ProductDetail> findByProductId(Long id);
    void save(ProductDetail productDetail);
}
