package com.redis.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.caching.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
