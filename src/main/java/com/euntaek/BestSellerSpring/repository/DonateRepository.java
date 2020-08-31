package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Donate;
import com.euntaek.BestSellerSpring.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DonateRepository extends JpaRepository<Donate,Long> {
    List<Donate> findByUserid(String user_id);
}
