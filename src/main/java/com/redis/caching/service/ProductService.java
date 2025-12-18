package com.redis.caching.service;

import org.springframework.stereotype.Service;

import com.redis.caching.entity.Product;
import com.redis.caching.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;
	private final ProductCacheService cache;

	public ProductService(ProductRepository repository, ProductCacheService cache) {
		this.repository = repository;
		this.cache = cache;
	}

	public Product get(Long Id) {
		Product cached = cache.get(Id);
		if (cached != null) {
			System.out.println("Returning product from Redis cache");
			return cached;
		}

		Product product = repository.findById(Id).orElseThrow(() -> new RuntimeException());

		cache.save(product);
		return product;
	}

	public Product create(Product p) {
		Product saved = repository.save(p);
		cache.save(saved);
		return saved;
	}

	public void delete(Long id) {
		repository.deleteById(id);
		cache.delete(id);
	}

}
