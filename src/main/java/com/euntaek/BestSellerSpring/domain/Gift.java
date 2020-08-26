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
@Getter //getter 자동생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
@Table(name="gift")
public class Gift {

    @Id
    private String user_id;
    @Column(name="target_id")
    private String target_id;
    @Column(name="bookname")
    private String bookname;
    @Column(name="author")
    private String author;

    @Builder
    public Gift(String user_id,String target_id,String bookname,String author){
        this.user_id=user_id;
        this.target_id=target_id;
        this.bookname=bookname;
        this.author=author;
    }
}
