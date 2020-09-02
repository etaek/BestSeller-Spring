package com.euntaek.BestSellerSpring.service;


import com.euntaek.BestSellerSpring.domain.Answer;
import com.euntaek.BestSellerSpring.domain.Message;
import com.euntaek.BestSellerSpring.dto.AnswerDto;
import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.dto.MessageDto;
import com.euntaek.BestSellerSpring.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor // 생성자 생성
@Transactional//트랜잭션 적용
public class MessageService {
    private MessageRepository messageRepository;
    public Long save(MessageDto messageDto){
        return messageRepository.save(messageDto.toEntity()).getM_num();
    }

    //질문 전체 불러오기
    public List<MessageDto> getMessageList(){
        List<Message>messages=messageRepository.findAll();
        List<MessageDto> messageDtoList=new ArrayList<>();
        for(Message message : messages){
            MessageDto messageDto=MessageDto.builder()
                    .m_num(message.getM_num())
                    .contents(message.getContents())
                    .user_id(message.getUser_id())
                    .c_num(message.getC_num())
                    .build();
            messageDtoList.add(messageDto);
        }
        return messageDtoList;

    }
}
