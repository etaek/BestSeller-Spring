package com.euntaek.BestSellerSpring.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name="donate")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 기본생성자 추가
public class Donate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long d_num;

    @Column(name="userid")
    private String userid;
    @Column(name="bookname")
    private String bookname;
    @Column(name="author")
    private String author;
    @Column(name="foundation")
    private String foundation;

    @Builder
    public Donate(Long d_num,String userid,String bookname, String author, String foundation){
        this.d_num=d_num;
        this.userid=userid;
        this.bookname=bookname;
        this.author=author;
        this.foundation=foundation;
    }


}
