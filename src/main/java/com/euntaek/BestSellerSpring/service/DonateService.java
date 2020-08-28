package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.repository.CountRepository;
import com.euntaek.BestSellerSpring.repository.DonateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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






}
