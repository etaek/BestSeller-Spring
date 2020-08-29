package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestSellerRepository extends JpaRepository<BestSeller,Long> {

}
