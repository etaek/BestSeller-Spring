package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.dto.BestSellerDto;
import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.dto.RecommendDto;
import com.euntaek.BestSellerSpring.service.BestSellerService;
import com.euntaek.BestSellerSpring.service.RecommendService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class RecommendController {
    private BestSellerService bestSellerService;
    private RecommendService recommendService;

    @GetMapping("/recommend")
    public String recommend(DonateDto donateDto, Model model){
        List<BestSellerDto> bestSellerDtoList=bestSellerService.getBestSellerlist();
        model.addAttribute("bestSellerList",bestSellerDtoList);

        List<RecommendDto> reviewDtoList=recommendService.getReviewList();
        model.addAttribute("reviewList",reviewDtoList);

        return "recommend/recommend";
    }

    @PostMapping("/review")
    public String review(RecommendDto recommendDto,Model model){
        recommendService.save(recommendDto);
        List<BestSellerDto> bestSellerDtoList=bestSellerService.getBestSellerlist();
        model.addAttribute("bestSellerList",bestSellerDtoList);

        List<RecommendDto> reviewDtoList=recommendService.getReviewList();
        model.addAttribute("reviewList",reviewDtoList);

        return "recommend/recommend";
    }
}
