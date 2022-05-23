package com.spring.week04.controller;

import com.spring.week04.models.Product;
import com.spring.week04.models.ProductMyPriceRequestDto;
import com.spring.week04.models.ProductRepository;
import com.spring.week04.models.ProductRequestDto;
import com.spring.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> readProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long updateMyprice(@PathVariable Long id, @RequestBody ProductMyPriceRequestDto requestDto){
        return productService.updateMyPrice(id, requestDto);
    }

}
