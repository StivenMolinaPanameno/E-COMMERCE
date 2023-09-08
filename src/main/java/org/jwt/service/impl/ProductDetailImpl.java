package org.jwt.service.impl;

import org.jwt.entities.Product;
import org.jwt.entities.ProductDetail;
import org.jwt.persistence.IProductDetailDAO;
import org.jwt.service.IProductDetailService;
import org.jwt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailImpl implements IProductDetailService {
    @Autowired
    IProductDetailDAO productDetailDAO;
    @Autowired
    IProductService productService;
    @Override
    public Optional<ProductDetail> findByProductId(Long id) {
        return productDetailDAO.findByProductId(id);
    }

    @Override
    public void save(ProductDetail productDetail) {
        productDetailDAO.save(productDetail);
    }

    @Override
    public void saveProductAndDetail(ProductDetail detail, Product product) {
        productService.save(product);
        productDetailDAO.save(detail);
    }
}
