package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private String user_id;
    private String pw;
    private String name;
    private String address;
    private String birth;

    public Member toEntity(){
        return Member.builder()
                .user_id(user_id)
                .pw(pw)
                .name(name)
                .address(address)
                .birth(birth)
                .build();
    }

    @Builder
    public MemberDto(String user_id,String pw,String name,String address,String birth){
        this.user_id=user_id;
        this.pw=pw;
        this.name=name;
        this.address=address;
        this.birth=birth;
    }
}
