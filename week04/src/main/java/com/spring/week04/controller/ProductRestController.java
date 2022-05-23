package com.spring.week04.controller;

import com.spring.week04.models.Product;
import com.spring.week04.models.ProductRepository;
import com.spring.week04.models.ProductRequestDto;
import com.spring.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @PostMapping("/api/products")
    public Product registerProduct(@RequestBody ProductRequestDto requestDto){

    }

    @GetMapping("/api/products")
    public List<Product> readProduct(){
        return productRepository.findAll();
    }

}
