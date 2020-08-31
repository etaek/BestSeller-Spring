package com.euntaek.BestSellerSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class UserDto {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    private String user_id=auth.getName();
}
