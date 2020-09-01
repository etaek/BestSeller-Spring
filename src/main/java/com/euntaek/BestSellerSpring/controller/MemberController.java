package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.dto.*;
import com.euntaek.BestSellerSpring.service.DonateService;
import com.euntaek.BestSellerSpring.service.GiftService;
import com.euntaek.BestSellerSpring.service.MemberService;
import com.euntaek.BestSellerSpring.service.RecommendService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    private RecommendService recommendService;
    private DonateService donateService;
    private GiftService giftService;

    //로그인 페이지
    @GetMapping("/login")
    public String loginForm(){
        return "user/login";
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String joinForm(){
        return "user/join";
    }

    //회원가입 처리
    @PostMapping("/join")
    public String join(MemberDto memberDto){
        memberService.save(memberDto);
        return "redirect:/";
    }

    //내정보 페이지
    @GetMapping("/myInfo")
    public String myInfo(MemberDto memberDto,UserDto userDto, Model model){

        MemberDto member= memberService.getUserInfo(userDto);
        model.addAttribute("member",member);

        List<RecommendDto> review=recommendService.getReview(userDto);
        model.addAttribute("reviewList",review);

        List<DonateDto> donate=donateService.getDonate(userDto);
        model.addAttribute("donateList",donate);

        List<GiftDto> gift=giftService.getGift(userDto);
        model.addAttribute("giftList",gift);
        return "user/myInfo";
    }

    //내정보 페이지
    @GetMapping("/modify")
    public String modify(MemberDto memberDto,UserDto userDto, Model model){
        MemberDto member= memberService.getUserInfo(userDto);
        model.addAttribute("member",member);


        return "user/modify";
    }
    @PutMapping("/modify")
    public String modifyChange(MemberDto memberDto,UserDto userDto, Model model){
        memberService.update(memberDto);
        MemberDto member= memberService.getUserInfo(userDto);
        model.addAttribute("member",member);


        List<RecommendDto> review=recommendService.getReview(userDto);
        model.addAttribute("reviewList",review);

        List<DonateDto> donate=donateService.getDonate(userDto);
        model.addAttribute("donateList",donate);

        List<GiftDto> gift=giftService.getGift(userDto);
        model.addAttribute("giftList",gift);

        return "user/myInfo";
    }





}
