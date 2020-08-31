package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.domain.Recommend;
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
public class RecommendDto {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private Long r_num;
    @Column(name="bname")
    private String bname;
    @Column(name="contents")
    private String contents;
    @Column(name="userid")
    private String userid=auth.getName();

    public Recommend toEntity(){
        return Recommend.builder()
                .r_num(r_num)
                .bname(bname)
                .contents(contents)
                .userid(userid)
                .build();
    }
    @Builder
    public RecommendDto(Long r_num,String bname,String contents,String userid){

        this.r_num=r_num;
        this.bname=bname;
        this.contents=contents;
        this.userid=userid;
    }
}
