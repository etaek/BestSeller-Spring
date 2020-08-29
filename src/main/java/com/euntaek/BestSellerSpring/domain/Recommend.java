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
    @Column(name="user_id")
    private String user_id;

    @Builder
    public Recommend(Long r_num,String bname,String contents,String user_id){
        this.r_num=r_num;
        this.bname=bname;
        this.contents=contents;
        this.user_id=user_id;
    }

}
