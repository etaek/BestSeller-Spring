package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecommendRepository extends JpaRepository<Recommend,Long> {

    List<Recommend> findByUserid(String user_id);

}
