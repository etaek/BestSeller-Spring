package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class CategoryDto {
    private Long c_num;
    private String category_title;

    public Category toEntity(){
        return Category.builder()
                .c_num(c_num)
                .category_title(category_title)
                .build();
    }

   @Builder
    public CategoryDto(Long c_num,String category_title){
        this.c_num=c_num;
        this.category_title=category_title;

    }
}
