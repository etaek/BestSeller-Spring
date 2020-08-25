package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
