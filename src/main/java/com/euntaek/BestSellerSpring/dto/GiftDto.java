package com.euntaek.BestSellerSpring.dto;


import com.euntaek.BestSellerSpring.domain.Gift;
import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.repository.CountRepository;
import com.euntaek.BestSellerSpring.service.GiftService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class GiftDto {


    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private String userid=auth.getName();
    private String target_id="user"+String.valueOf((int)((Math.random()*1100)+1));;
    private String bookname;
    private String author;

    public Gift toEntity(){
        return Gift.builder()
                .userid(userid)
                .target_id(target_id)
                .bookname(bookname)
                .author(author)
                .build();
    }

    @Builder
    public GiftDto(String userid,String target_id,String bookname,String author){
        this.userid=userid;
        this.target_id=target_id;
        this.bookname=bookname;
        this.author=author;
    }
}
