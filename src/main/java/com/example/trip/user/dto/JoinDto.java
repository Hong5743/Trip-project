package com.example.trip.user.dto;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JoinDto {
    //Entity 말고 Dto를 따로 만들어 사용한다.
    private String memberId;
    private String memberPasswd;
    private String memberName;
    private String memberNickname;
    private String memberEmail;
    private String memberTell;
    private String memberBirth;
    private OffsetDateTime memberRegdate;
    private OffsetDateTime memberWithdraw;
    private int memberGrade;
    private MemberRole role;
    private int memberState;

    public JoinDto(String memberId, String memberPasswd, String memberName, String memberNickname,
                   String memberEmail, String memberTell, String memberBirth, OffsetDateTime memberRegdate,
                   OffsetDateTime memberWithdraw, int memberGrade, MemberRole role, int memberState) {
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberTell = memberTell;
        this.memberBirth = memberBirth;
        this.memberRegdate = memberRegdate;
        this.memberWithdraw = memberWithdraw;
        this.memberGrade = memberGrade;
        this.role = role;
        this.memberState = memberState;
    }

    public Member toEntity() {
        return Member.builder()
                .memberId(memberId)
                .memberPasswd(memberPasswd)
                .memberName(memberName)
                .memberNickname(memberNickname)
                .memberEmail(memberEmail)
                .memberTell(memberTell)
                .memberBirth(memberBirth)
                .memberRegdate(OffsetDateTime.now())
                .memberWithdraw(null)
                .memberGrade(0)
                .role(MemberRole.USER)
                .memberState(0)
                .build();
    }
}
