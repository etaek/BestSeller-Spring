package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import com.euntaek.BestSellerSpring.dto.BestSellerDto;
import com.euntaek.BestSellerSpring.repository.BestSellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BestSellerService {
    private BestSellerRepository bestSellerRepository;

    public List<BestSellerDto> getBestSellerlist(){
        List<BestSeller>bestsellers=bestSellerRepository.findAll();
        List<BestSellerDto>bestSellerDtoList=new ArrayList<>();

        for(BestSeller best: bestsellers){
            BestSellerDto bestSellerDto=BestSellerDto.builder()
                    .b_id(best.getB_id())
                    .bname(best.getBname())
                    .image(best.getImage())
                    .build();
            bestSellerDtoList.add(bestSellerDto);
        }
        return bestSellerDtoList;
    }
}
