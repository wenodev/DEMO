package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.MemberRepository;
import com.demo.demo0617.common.domain.Role;
import com.demo.demo0617.common.dto.MemberDto;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Transactional
    public Member findById(Long id){

        Optional<Member> optional = memberRepository.findById(id);
        Member member = null;

        if(optional.isPresent()){
            member = optional.get();
        }else{
            throw new RuntimeException("Member not found for id : " + id);
        }
        return member;
    }

    @Transactional
    public Member findByEmail(String name){

        Optional<Member> optional = memberRepository.findByEmail(name);
        Member member = null;

        if(optional.isPresent()){
            member = optional.get();
        }else{
            throw new RuntimeException("Member not found for name : " + name);
        }

        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Member> userEntityWrapper = memberRepository.findByEmail(userEmail);
        Member userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

}
