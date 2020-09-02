package com.euntaek.BestSellerSpring.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class AnswerDto {
    private Long m_num;
    private String content;

    @Builder
    public AnswerDto(Long m_num, String content){
        this.m_num=m_num;
        this.content=content;
    }
}
