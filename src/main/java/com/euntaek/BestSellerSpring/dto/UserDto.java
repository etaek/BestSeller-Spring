package com.euntaek.BestSellerSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class UserDto { //현재 로그인된 유저 아이디
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private String user_id=auth.getName();
}
