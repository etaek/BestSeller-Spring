package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

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




}
