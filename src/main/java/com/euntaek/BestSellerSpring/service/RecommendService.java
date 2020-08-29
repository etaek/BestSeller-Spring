package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import com.euntaek.BestSellerSpring.domain.Recommend;
import com.euntaek.BestSellerSpring.dto.BestSellerDto;
import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.dto.RecommendDto;
import com.euntaek.BestSellerSpring.repository.RecommendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor // 생성자 생성
@Transactional//트랜잭션 적용
public class RecommendService {
    private RecommendRepository recommendRepository;

    //리뷰 데이터 저장
    public Long save(RecommendDto recommendDto){

        return recommendRepository.save(recommendDto.toEntity()).getR_num();
    }

    public List<RecommendDto> getReviewList(){
        List<Recommend>reviews=recommendRepository.findAll();
        List<RecommendDto> reviewDtoList=new ArrayList<>();

        for(Recommend review: reviews){
            RecommendDto recommendDto=RecommendDto.builder()
                    .r_num(review.getR_num())
                    .bname(review.getBname())
                    .contents(review.getContents())
                    .user_id(review.getUser_id())
                    .build();

            reviewDtoList.add(recommendDto);
        }
        return reviewDtoList;
    }
}
