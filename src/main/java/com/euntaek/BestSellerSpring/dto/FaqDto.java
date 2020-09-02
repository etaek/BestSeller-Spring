package com.euntaek.BestSellerSpring.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class FaqDto {
    private String question;
    private String answer;

    @Builder
    public FaqDto(String question,String answer){
        this.question=question;
        this.answer=answer;
    }
}
