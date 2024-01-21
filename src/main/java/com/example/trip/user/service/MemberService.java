package com.example.trip.user.service;

import com.example.trip.user.dto.JoinDto;
import com.example.trip.user.dto.Member;
import com.example.trip.user.dto.MemberSessionDto;
import com.example.trip.user.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    HttpSession session;

    public void insertUser(JoinDto dto) {
        dto.setMemberPasswd(encoder.encode(dto.getMemberPasswd()));
        memberRepository.save(dto.toEntity());
    }
    //username 이 DB에 있는지 확인
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(memberId);
        if (member != null) {
            return new MemberDetails(member);
        }
       return null;
    }
}
