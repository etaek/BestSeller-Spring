package com.euntaek.BestSellerSpring.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long m_num;
    @Column(name="contents")
    private String contents;
    @Column(name="user_id")
    private String user_id;
    @Column(name="c_num")
    private Long c_num;

    @Builder
    public Message(Long m_num,String contents,String user_id,Long c_num){
        this.m_num=m_num;
        this.user_id=user_id;
        this.contents=contents;
        this.c_num=c_num;
    }

}
