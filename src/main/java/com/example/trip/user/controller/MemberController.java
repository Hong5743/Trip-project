package com.example.trip.user.controller;

import com.example.trip.user.dto.MemberSessionDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String login(){
        return "user/loginForm";
    }

//    @PostMapping("/loginProc")
//    public String loginP(Model model,HttpSession session){
//        MemberSessionDto sessionDto = (MemberSessionDto) session.getAttribute("session");
//        if (sessionDto != null) {
//            model.addAttribute("session", sessionDto.getMemberNickname());
//        }
//      return "/";
//    }

    @GetMapping("/join")
    public String joinUser() {
        return "user/joinForm";
    }
}
