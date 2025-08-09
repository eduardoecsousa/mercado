package com.mercado.mercado.Models.Repositories;

import com.mercado.mercado.Models.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
