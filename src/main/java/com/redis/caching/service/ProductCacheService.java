package com.redis.caching.service;

import com.redis.caching.entity.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class ProductCacheService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final String PREFIX = "product:";

    public ProductCacheService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Product get(Long id) {
        return (Product) redisTemplate.opsForValue().get(PREFIX + id);
    }

    public void save(Product product) {
        redisTemplate.opsForValue().set(
            PREFIX + product.getId(),
            product,
            10, TimeUnit.MINUTES
        );
    }

    public void delete(Long id) {
        redisTemplate.delete(PREFIX + id);
    }
}
