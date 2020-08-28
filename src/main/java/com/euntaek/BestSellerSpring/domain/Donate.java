package com.euntaek.BestSellerSpring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name="donate")
public class Donate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long d_num;

    @Column(name="user_id")
    private String user_id;
    @Column(name="bookname")
    private String bookname;
    @Column(name="author")
    private String author;
    @Column(name="foundation")
    private String foundation;

    @Builder
    public Donate(Long d_num,String user_id,String bookname, String author, String foundation){
        this.d_num=d_num;
        this.user_id=user_id;
        this.bookname=bookname;
        this.author=author;
        this.foundation=foundation;
    }


}
