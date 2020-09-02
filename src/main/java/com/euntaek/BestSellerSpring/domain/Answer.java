package com.euntaek.BestSellerSpring.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
@Table(name="answer")
public class Answer {
    @Id
    private Long m_num;
    @Column(name="content")
    private String content;

    @Builder
    public Answer(Long m_num, String content){
        this.m_num=m_num;
        this.content=content;
    }
}
