package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class MemberDto {

    private String user_id;
    private String password;
    private String name;
    private String address;
    private String birth;

    public Member toEntity(){
        return Member.builder()
                .user_id(user_id)
                .password(password)
                .name(name)
                .address(address)
                .birth(birth)
                .build();
    }



    @Builder
    public MemberDto(String user_id,String password,String name,String address,String birth){
        this.user_id=user_id;
        this.password=password;
        this.name=name;
        this.address=address;
        this.birth=birth;
    }
}
