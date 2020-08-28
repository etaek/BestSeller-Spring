package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.dto.GiftDto;
import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.service.DonateService;
import com.euntaek.BestSellerSpring.service.GiftService;
import com.euntaek.BestSellerSpring.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {
    private GiftService giftService;
    private MemberService memberService;


    //책 선물 페이지
    @GetMapping("/gift")
    public String gift(){
        return "book/gift";
    }

    //책 선물 데이터 처리
    @PostMapping("/gift")
    public String gift(GiftDto giftDto, Model model){

        giftService.save(giftDto);
        MemberDto member=memberService.getMemberList(giftDto);
        model.addAttribute("name",member.getName());
        model.addAttribute("address",member.getAddress());
        return "book/giftResult";
    }




}
