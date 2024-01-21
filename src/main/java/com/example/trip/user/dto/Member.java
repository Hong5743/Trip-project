package com.example.trip.user.dto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.AuthenticatedPrincipal;

import java.time.OffsetDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;
    @Column(nullable = false, unique = true)
    private String memberId;
    @Column(nullable = false)
    private String memberPasswd;
    @Column(nullable = false)
    private String memberName;
    @Column(nullable = false, unique = true)
    private String memberNickname;
    @Column(nullable = false, unique = true)
    private String memberEmail;
    @Column(nullable = false, unique = true)
    private String memberTell;
    @Column(nullable = false)
    private String memberBirth;
    @Column(nullable = false)
    private OffsetDateTime memberRegdate;
    @Column
    private OffsetDateTime memberWithdraw;
    @Column
    private int memberGrade;
    @Enumerated(EnumType.STRING)
    private MemberRole role;
    @Column
    private int memberState;

}
