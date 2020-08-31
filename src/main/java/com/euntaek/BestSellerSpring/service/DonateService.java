package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.Donate;
import com.euntaek.BestSellerSpring.domain.Recommend;
import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.dto.RecommendDto;
import com.euntaek.BestSellerSpring.dto.UserDto;
import com.euntaek.BestSellerSpring.repository.CountRepository;
import com.euntaek.BestSellerSpring.repository.DonateRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class DonateService {
    private DonateRepository donateRepository;
    private CountRepository countRepository;

    //기부 폼 데이터 저장
    public Long save(DonateDto donateDto){
        return donateRepository.save(donateDto.toEntity()).getD_num();

    }
    //기부 순위 횟수
    public List <Long> findCount(){
        return countRepository.findCount();
    }
    //기부 순위 이름
    public List <String> findId(){
        return countRepository.findId();
    }

    //기부 불러오기
    public List<DonateDto> getDonate(UserDto userDto){
        List<Donate> donates=donateRepository.findByUserid(userDto.getUser_id());
        List<DonateDto>donateDtoList=new ArrayList<>();

        for(Donate donate : donates){
            DonateDto donateDto=DonateDto.builder()
                    .d_num(donate.getD_num())
                    .userid(donate.getUserid())
                    .bookname(donate.getBookname())
                    .author(donate.getAuthor())
                    .foundation(donate.getFoundation())
                    .build();

            donateDtoList.add(donateDto);
        }
        return donateDtoList;

    }





}
