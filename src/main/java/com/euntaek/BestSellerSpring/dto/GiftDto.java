package com.euntaek.BestSellerSpring.dto;


import com.euntaek.BestSellerSpring.domain.Gift;
import com.euntaek.BestSellerSpring.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class GiftDto {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private String user_id=auth.getName();
    private String target_id="user"+String.valueOf((int)((Math.random()*1100)+1));;
    private String bookname;
    private String author;

    public Gift toEntity(){
        return Gift.builder()
                .user_id(user_id)
                .target_id(target_id)
                .bookname(bookname)
                .author(author)
                .build();
    }

    @Builder
    public GiftDto(String user_id,String target_id,String bookname,String author){
        this.user_id=user_id;
        this.target_id=target_id;
        this.bookname=bookname;
        this.author=author;
    }
}
