package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend,Long> {
}
