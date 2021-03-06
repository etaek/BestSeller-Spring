package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.Donate;
import com.euntaek.BestSellerSpring.domain.Gift;
import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.dto.GiftDto;
import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.dto.UserDto;
import com.euntaek.BestSellerSpring.repository.CountRepository;
import com.euntaek.BestSellerSpring.repository.GiftRepository;
import com.euntaek.BestSellerSpring.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // 생성자 생성
@Transactional//트랜잭션 적용
public class GiftService {
    private GiftRepository giftRepository;
    private CountRepository countRepository;
    public String save(GiftDto giftDto){

        return giftRepository.save(giftDto.toEntity()).getUserid();
    }

    //선물 불러오기
    public List<GiftDto> getGift(UserDto userDto){
        List<Gift> gifts=giftRepository.findByUserid(userDto.getUser_id());
        List<GiftDto>giftDtoList=new ArrayList<>();

        for(Gift gift : gifts){
            GiftDto giftDto=GiftDto.builder()
                    .userid(gift.getUserid())
                    .target_id(gift.getTarget_id())
                    .bookname(gift.getBookname())
                    .author(gift.getAuthor())
                    .build();


            giftDtoList.add(giftDto);
        }
        return giftDtoList;

    }







}
