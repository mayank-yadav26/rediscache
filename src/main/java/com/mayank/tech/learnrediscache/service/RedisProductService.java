package com.mayank.tech.learnrediscache.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.mayank.tech.learnrediscache.model.Product;

@Service
public class RedisProductService {

    private final RedisTemplate<String, Product> redisTemplate;
    
    public RedisProductService(RedisTemplate<String, Product> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String KEY = "RedisProduct::";

    public void saveProduct(Product product) {
        redisTemplate.opsForValue().set(KEY + product.getId(), product);
    }

    public Product getProduct(int id) {
        return redisTemplate.opsForValue().get(KEY + id);
    }

    public void deleteProduct(int id) {
        redisTemplate.delete(KEY + id);
    }
}

