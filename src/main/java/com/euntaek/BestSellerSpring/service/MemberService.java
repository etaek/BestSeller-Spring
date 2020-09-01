package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.BestSeller;
import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.domain.Role;
import com.euntaek.BestSellerSpring.dto.BestSellerDto;
import com.euntaek.BestSellerSpring.dto.GiftDto;
import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.dto.UserDto;
import com.euntaek.BestSellerSpring.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // 생성자 생성
@Transactional
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    public Long save(MemberDto memberDto){
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    public Long update(MemberDto memberDto){

        System.out.println(memberDto.getUserid());
        System.out.println(memberDto.getPassword());

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    public MemberDto getMemberList(GiftDto giftDto){ //gift 결과 목록
        Optional<Member> target=memberRepository.findByUserid(giftDto.getTarget_id());
        System.out.println(giftDto.getTarget_id());
        Member member=target.get();
        System.out.println(member.getUserid());
        MemberDto memberDTO = MemberDto.builder()
                .id(member.getId())
                .userid(member.getUserid())
                .password(member.getPassword())
                .name(member.getName())
                .address(member.getAddress())
                .birth(member.getBirth())
                .build();



        return memberDTO;
    }

    public MemberDto getUserInfo(UserDto userDto){ //멤버 정보
        Optional<Member> target=memberRepository.findByUserid(userDto.getUser_id());
        Member member=target.get();

        MemberDto memberDTO = MemberDto.builder()
                .id(member.getId())
                .userid(member.getUserid())
                .password(member.getPassword())
                .name(member.getName())
                .address(member.getAddress())
                .birth(member.getBirth())
                .build();



        return memberDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

        Optional<Member> userEntityWrapper = memberRepository.findByUserid(user_id);
        Member member = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("dmsxor").equals(user_id)) {

            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(member.getUserid(), member.getPassword(), authorities);

    }
}
