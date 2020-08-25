package com.euntaek.BestSellerSpring.service;

import com.euntaek.BestSellerSpring.domain.Member;
import com.euntaek.BestSellerSpring.domain.Role;
import com.euntaek.BestSellerSpring.dto.MemberDto;
import com.euntaek.BestSellerSpring.repository.MemberRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // 생성자 생성
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional //트랜잭션 적용
    public String save(MemberDto memberDto){
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getUser_id();
    }

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

        Optional<Member> userEntityWrapper = memberRepository.findById(user_id);
        Member member = userEntityWrapper.get();
        System.out.println(member.getUser_id());
        System.out.println(member.getPassword());
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("dmsxor").equals(user_id)) {

            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(member.getUser_id(), member.getPassword(), authorities);

    }
}
