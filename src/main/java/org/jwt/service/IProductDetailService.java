package org.jwt.service;

import org.jwt.entities.Product;
import org.jwt.entities.ProductDetail;

import java.util.Optional;

public interface IProductDetailService {
    Optional<ProductDetail> findByProductId(Long id);
    void save(ProductDetail productDetail);
    void saveProductAndDetail(ProductDetail detail, Product product);
}
