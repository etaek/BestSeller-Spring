package com.euntaek.BestSellerSpring.service;


import com.euntaek.BestSellerSpring.domain.Answer;
import com.euntaek.BestSellerSpring.domain.Recommend;
import com.euntaek.BestSellerSpring.dto.AnswerDto;
import com.euntaek.BestSellerSpring.dto.RecommendDto;
import com.euntaek.BestSellerSpring.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AnswerService {
    private AnswerRepository answerRepository;

    //답변 전체 불러오기
    public List<AnswerDto> getAnswerList(){
        List<Answer>answers=answerRepository.findAll();
        List<AnswerDto> answerDtoList=new ArrayList<>();

        for(Answer answer : answers){
            AnswerDto answerDto=AnswerDto.builder()
                    .m_num(answer.getM_num())
                    .content(answer.getContent())
                    .build();
            answerDtoList.add(answerDto);
        }
        return answerDtoList;
    }
}
