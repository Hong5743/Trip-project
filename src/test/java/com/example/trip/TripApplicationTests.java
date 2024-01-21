package com.example.trip;

import com.example.trip.user.dto.Member;
import com.example.trip.user.dto.MemberRole;
import com.example.trip.user.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TripApplicationTests {

    @Test
    void contextLoads() {
    }

}
