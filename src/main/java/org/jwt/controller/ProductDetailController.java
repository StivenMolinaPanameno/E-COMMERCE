package org.jwt.controller;

import jakarta.validation.Valid;
import org.jwt.controller.DTO.ProductDetailDTO;
import org.jwt.entities.Product;
import org.jwt.entities.ProductDetail;
import org.jwt.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductDetailController {
    @Autowired
    IProductDetailService service;

    @PostMapping("/saveDetail")
    public ResponseEntity<?> save(
            @Valid @RequestBody ProductDetailDTO productDetailDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Check that the fields are valid");
        }
        Product product = Product.builder()
                .name(productDetailDTO.getName())
                .stock(productDetailDTO.getStock())
                .price(productDetailDTO.getPrice())
                .brand(productDetailDTO.getBrand())
                .category(productDetailDTO.getCategory())
                .enabled(true)
                .build();

        ProductDetail productDetail = ProductDetail.builder()
                .description(productDetailDTO.getDescription())
                .weight(productDetailDTO.getWeight())
                .warranty(productDetailDTO.getWarranty())
                .fabrication(productDetailDTO.getFabrication())
                .product(product)
                .build();

        service.saveProductAndDetail(productDetail, product);

        return ResponseEntity.ok("Product and Detail created successfully");


    }

    @GetMapping("/findDetail/{id}")
    public ResponseEntity<?> findDetailProduct(@PathVariable Long id){
        Optional<ProductDetail> detail = service.findByProductId(id);
        if(detail.isPresent()){
            return ResponseEntity.ok(detail);
        }
        return ResponseEntity.notFound().build();
    }
}
