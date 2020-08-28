package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Donate;
import com.euntaek.BestSellerSpring.domain.Gift;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class DonateDto {
    private Long d_num;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private String user_id=auth.getName();
    private String bookname;
    private String author;
    private String foundation;

    public Donate toEntity(){
        return Donate.builder()
                .d_num(d_num)
                .user_id(user_id)
                .bookname(bookname)
                .author(author)
                .foundation(foundation)
                .build();
    }

    @Builder
    public DonateDto(Long d_num,String user_id,String bookname, String author, String foundation){
        this.d_num=d_num;
        this.user_id=user_id;
        this.bookname=bookname;
        this.author=author;
        this.foundation=foundation;
    }
}
