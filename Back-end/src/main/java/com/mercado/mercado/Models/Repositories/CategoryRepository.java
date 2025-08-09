package com.mercado.mercado.Models.Repositories;

import com.mercado.mercado.Models.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
