package com.kh.demo.web;

import com.kh.demo.web.form.member.JoinForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {

  //회원가입양식
  @GetMapping("/join")
  public String joinForm(){
    return "member/joinForm";
  }

  //회원가입처리
  @PostMapping("/join")
  public String join(JoinForm joinForm){
    log.info("joinForm={}", joinForm);


    return "redirect:/";
  }
}
