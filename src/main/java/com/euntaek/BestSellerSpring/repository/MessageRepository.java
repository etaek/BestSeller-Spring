package com.euntaek.BestSellerSpring.repository;

import com.euntaek.BestSellerSpring.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
