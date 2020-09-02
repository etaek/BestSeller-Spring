package com.euntaek.BestSellerSpring.controller;

import com.euntaek.BestSellerSpring.domain.Message;
import com.euntaek.BestSellerSpring.dto.*;
import com.euntaek.BestSellerSpring.service.AnswerService;
import com.euntaek.BestSellerSpring.service.CategoryService;
import com.euntaek.BestSellerSpring.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private CategoryService categoryService;
    private MessageService messageService;
    private AnswerService answerService;
    @GetMapping("/")
    public String main(Model model){
        List<CategoryDto> list=categoryService.getCategory();
        model.addAttribute("categoryList",list);
        return "main";
    }
    @PostMapping("/message")
    public String message(MessageDto messageDto,Model model){
        messageService.save(messageDto);
        List<CategoryDto> list=categoryService.getCategory();
        model.addAttribute("categoryList",list);
        return "main";
    }
    @GetMapping("/faq")
    public String faq(Model model){
        List<MessageDto> messageList=messageService.getMessageList();
        List<AnswerDto> answerList=answerService.getAnswerList();
        List<FaqDto> faqList=new ArrayList<>();
        for(AnswerDto answerDto : answerList){
            for(MessageDto messageDto:messageList){
                if(answerDto.getM_num()==messageDto.getM_num()){
                    FaqDto faqDto=FaqDto.builder()
                            .question(messageDto.getContents())
                            .answer(answerDto.getContent())
                            .build();
                    faqList.add(faqDto);
                    break;
                }
            }
        }

        model.addAttribute("faq",faqList);
        return "faq";
    }

    @GetMapping("/about")
    public String about(){
        return "aboutUs";
    }
}
