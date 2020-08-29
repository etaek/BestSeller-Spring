package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import com.euntaek.BestSellerSpring.domain.Gift;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class BestSellerDto {

    private Long b_id;
    private String bname;
    private String image;

    public BestSeller toEntity(){
        return BestSeller.builder()
                .b_id(b_id)
                .bname(bname)
                .image(image)
                .build();

    }
    @Builder
    public BestSellerDto(Long b_id,String bname,String image){
        this.b_id=b_id;
        this.bname=bname;
        this.image=image;
    }
}
