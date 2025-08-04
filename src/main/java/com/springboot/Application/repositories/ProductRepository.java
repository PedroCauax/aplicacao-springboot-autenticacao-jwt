package com.springboot.Application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.Application.models.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{
}
