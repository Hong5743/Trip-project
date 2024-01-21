package com.example.trip.user.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class MemberSessionDto implements Serializable {
    private String memberName;
    private String memberNickname;
    private String memberEmail;
    private String memberTell;
    private String memberBirth;
    private int memberRegdate;
    private MemberRole role;

    public MemberSessionDto(Member member) {
        this.memberName = member.getMemberName();
        this.memberNickname = member.getMemberNickname();
        this.memberEmail = member.getMemberEmail();
        this.memberTell = member.getMemberTell();
        this.memberBirth = member.getMemberBirth();
        this.memberRegdate = member.getMemberGrade();
        this.role = member.getRole();
    }
}
