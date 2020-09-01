package com.euntaek.BestSellerSpring.dto;

import com.euntaek.BestSellerSpring.domain.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor   //인자가없는
public class MemberDto {
    private Long id;
    private String userid;
    private String password;
    private String name;
    private String address;
    private String birth;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .userid(userid)
                .name(name)
                .address(address)
                .password(password)
                .birth(birth)
                .build();
    }



    @Builder
    public MemberDto(Long id,String userid,String name,String address,String password,String birth){
        this.id=id;
        this.userid=userid;
        this.name=name;
        this.address=address;
        this.password=password;
        this.birth=birth;
    }
}
