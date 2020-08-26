package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Gift;
import com.euntaek.BestSellerSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findById(String user_id);


}
