package com.mayank.tech.learnrediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.tech.learnrediscache.model.Product;
import com.mayank.tech.learnrediscache.service.RedisProductService;

@RestController
@RequestMapping("/manual-products")
public class RedisProductController {

    @Autowired
    private RedisProductService redisProductService;

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        redisProductService.saveProduct(product);
        return "Product saved to Redis";
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return redisProductService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        redisProductService.deleteProduct(id);
        return "Product removed from Redis";
    }
}

