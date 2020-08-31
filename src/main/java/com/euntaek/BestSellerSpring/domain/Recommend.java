package com.euntaek.BestSellerSpring.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
@Table(name="review")
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_num;

    @Column(name="bname")
    private String bname;
    @Column(name="contents")
    private String contents;
    @Column(name="userid")
    private String userid;

    @Builder
    public Recommend(Long r_num,String bname,String contents,String userid){
        this.r_num=r_num;
        this.bname=bname;
        this.contents=contents;
        this.userid=userid;
    }

}
