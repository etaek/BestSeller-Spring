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
@Table(name="bestseller")
public class BestSeller {
    @Id
    private Long b_id;

    @Column(name="bname")
    private String bname;

    @Column(name="image")
    private String image;

    @Builder
    public BestSeller(Long b_id,String bname,String image){
        this.b_id=b_id;
        this.bname=bname;
        this.image=image;
    }

}
