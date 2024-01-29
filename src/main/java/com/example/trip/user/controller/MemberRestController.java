package com.example.trip.user.controller;

import com.example.trip.user.dto.JoinDto;
import com.example.trip.user.dto.ResponseDto;
import com.example.trip.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberRestController {
    @Autowired
    private MemberService userService;

    @ResponseBody
    @PostMapping("/api/signUp")
    public ResponseDto<Integer> saveUser(@RequestBody JoinDto dto){
        System.out.println("dto========================="+dto);
        userService.insertUser(dto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 통신 성공 : 200, 실패 : 500 // 자바 오브젝트를 JSON으로 변환해서 리턴 (Jackson)
    }

    @ResponseBody
    @PostMapping("/api/ConfirmId")
    public ResponseEntity<Boolean> confirmId(String memberId) {
        boolean result = true;
        if(memberId.trim().isEmpty()) {
            result = false;
        } else {
            if (userService.checkMemberId(memberId)) {
                result = false;
            } else {
                result = true;
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
