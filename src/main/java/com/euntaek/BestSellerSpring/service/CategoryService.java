package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.Category;
import com.euntaek.BestSellerSpring.domain.Recommend;
import com.euntaek.BestSellerSpring.dto.CategoryDto;
import com.euntaek.BestSellerSpring.dto.RecommendDto;
import com.euntaek.BestSellerSpring.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getCategory(){

        List<Category>categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtoList=new ArrayList<>();

        for(Category category: categories){
            CategoryDto categoryDto=CategoryDto.builder()
                    .c_num(category.getC_num())
                    .category_title(category.getCategory_title())
                    .build();
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
