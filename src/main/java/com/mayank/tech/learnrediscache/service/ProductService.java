package com.mayank.tech.learnrediscache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mayank.tech.learnrediscache.model.Product;

@Service
public class ProductService {

    // Simulate heavy DB fetch
    @Cacheable(value = "products", key = "#id")
    public Product getProductById(int id) {
        System.out.println("Fetching from DB...");
        try {
            Thread.sleep(2000); // simulate delay
        } catch (InterruptedException e) {}
        return new Product(id, "Laptop", 999.99);
    }

    @CacheEvict(value = "products", key = "#id")
    public void evictCache(int id) {
        System.out.println("Cache cleared for ID: " + id);
    }
}
