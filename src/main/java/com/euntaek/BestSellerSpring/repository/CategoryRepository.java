package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
