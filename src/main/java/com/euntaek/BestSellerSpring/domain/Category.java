package com.euntaek.BestSellerSpring.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter //getter 자동생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long c_num;

    @Column(name="category_title")
    private String category_title;

    @Builder
    public Category(Long c_num,String category_title){
        this.c_num=c_num;
        this.category_title=category_title;
    }
}
