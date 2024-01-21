package com.example.trip.user.repository;

import com.example.trip.user.dto.Member;
import com.example.trip.user.dto.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Member findByMember_idAndMember_passwd(String member_id, String member_passwd);//로그인 유효성검사

    Member findByMemberId(String memberId);
}

