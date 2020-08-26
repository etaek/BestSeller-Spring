package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Gift;
import com.euntaek.BestSellerSpring.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GiftRepository extends JpaRepository<Gift, String>{


}
