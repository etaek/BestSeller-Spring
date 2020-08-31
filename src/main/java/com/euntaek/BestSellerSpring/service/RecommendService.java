package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.domain.Recommend;
import com.euntaek.BestSellerSpring.dto.*;
import com.euntaek.BestSellerSpring.repository.RecommendRepository;
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
public class RecommendService {
    private RecommendRepository recommendRepository;
    
    //리뷰 데이터 저장
    public Long save(RecommendDto recommendDto){

        return recommendRepository.save(recommendDto.toEntity()).getR_num();
    }
    //리뷰 전체 불러오기
    public List<RecommendDto> getReviewList(){
        List<Recommend>reviews=recommendRepository.findAll();
        List<RecommendDto> recommendDtoList=new ArrayList<>();

        for(Recommend recommend : reviews){
            RecommendDto recommendDto=RecommendDto.builder()
                    .r_num(recommend.getR_num())
                    .bname(recommend.getBname())
                    .contents(recommend.getContents())
                    .userid(recommend.getUserid())
                    .build();
            recommendDtoList.add(recommendDto);
        }
        return recommendDtoList;
    }

    //리뷰 불러오기
    public List<RecommendDto> getReview(UserDto userDto){
        List<Recommend> review=recommendRepository.findByUserid(userDto.getUser_id());
        List<RecommendDto>recommendDtoList=new ArrayList<>();

        for(Recommend recommend : review){
            RecommendDto recommendDto=RecommendDto.builder()
                    .r_num(recommend.getR_num())
                    .bname(recommend.getBname())
                    .contents(recommend.getContents())
                    .userid(recommend.getUserid())
                    .build();
            recommendDtoList.add(recommendDto);
        }
        return recommendDtoList;

    }


}
