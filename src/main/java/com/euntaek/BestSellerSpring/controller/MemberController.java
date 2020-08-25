package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto){
        memberService.save(memberDto);
        return "redirect:/";
    }
}
