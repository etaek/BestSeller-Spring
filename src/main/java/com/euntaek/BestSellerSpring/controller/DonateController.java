package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.dto.DonateDto;
import com.euntaek.BestSellerSpring.service.DonateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class DonateController {

    private DonateService donateService;

    //책 기부 페이지(데이터 뿌려주기)
    @GetMapping("/donate")
    public String donate(Model model){
        List<Long> count=donateService.findCount();
        List<String> id=donateService.findId();
        int j = 0;
        for(Long i : count){
            model.addAttribute("count"+j++,i);
        }
        j=0;
        for(String i : id){
            model.addAttribute("id"+j++,i);

        }

        return "donate/donation";
    }

    //책 기부 폼 페이지
    @GetMapping("/donateForm")
    public String donateForm(){
        return "donate/donateForm";
    }

    //책 기부 데이터 처리
    @PostMapping("/donateForm")
    public String donateForm(DonateDto donateDto){
        donateService.save(donateDto);
        return "donate/donateSuccess";
    }
}
