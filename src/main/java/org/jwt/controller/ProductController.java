package org.jwt.controller;

import jakarta.validation.Valid;
import org.jwt.controller.DTO.ProductDTO;
import org.jwt.entities.Product;
import org.jwt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    IProductService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        return productOptional.map(product -> ResponseEntity.ok(convertToDto(product)))
                .orElse(ResponseEntity.badRequest().build());
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) throws URISyntaxException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation Errors");
        }
        service.save(convertToEntity(productDTO));
        return ResponseEntity.created(new URI("/api/v1/products")).build();
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findName(@PathVariable String name){
        Optional<Product> productOptional = service.findByName(name);
        return productOptional.map(product -> ResponseEntity.ok(convertToDto(product)))
                .orElse(ResponseEntity.badRequest().build());
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> productList =  service.findAll().stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<?> findByCategory(@PathVariable String category){
        List<ProductDTO> productList =  service.findByCategory(category).stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
            product.setEnabled(productDTO.getEnabled());
            product.setStock(productDTO.getStock());
            product.setBrand(productDTO.getBrand());

            service.save(product);
            return ResponseEntity.ok(product);
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/disableById/{id}")
    public ResponseEntity<?> disableById(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            service.disableById(id);
            return ResponseEntity.ok("Product Disable");
        }
        return ResponseEntity.notFound().build();
    }



    private ProductDTO convertToDto(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .enabled(product.getEnabled())
                .build();
    }
    private Product convertToEntity(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .brand(productDTO.getBrand())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .category(productDTO.getCategory())
                .enabled(productDTO.getEnabled())
                .build();
    }
}
