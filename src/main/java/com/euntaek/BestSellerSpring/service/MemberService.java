package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Transactional
    public String save(MemberDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getUser_id();
    }
}
