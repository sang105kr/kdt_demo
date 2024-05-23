package com.kh.demo.web;

import com.kh.demo.domain.common.mail.MailService;
import com.kh.demo.domain.entity.Member;
import com.kh.demo.domain.member.svc.MemberSVC;
import com.kh.demo.web.form.member.JoinForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberSVC memberSVC;
  private final MailService mailService;

  //회원가입양식
  @GetMapping("/join")
  public String joinForm(){
    return "member/joinForm";
  }

  //회원가입처리
  @PostMapping("/join")
  public String join(JoinForm joinForm){
    log.info("joinForm={}", joinForm);
    //1)유효성 검증
    
    //2)가입처리
    Member member = new Member();
    BeanUtils.copyProperties(joinForm,member);
    Long memberId = memberSVC.joinMember(member);

    return (memberId !=null ) ? "redirect:/login" : "redirect:/join";
  }

  //비밀번호 찾기 양식
  @GetMapping("/findPwd")
  public String findPwdForm(){

    return "member/findPwdForm";
  }

//  //비밀번호 찾기
//  @ResponseBody
//  @PostMapping("/findPwd")
//  public String findPwd(
//          @RequestParam("email") String email,
//          @RequestParam("nickname") String nickname){
//
//    log.info("email=",email);
//    log.info("nickname=",nickname);
//
//    boolean hasPasswd = memberSVC.hasPasswd(email, nickname);
//    if (hasPasswd) {
//      // 1)임시번호 생성 6자리 랜덤 생성
//      String tmpPwd = UUID.randomUUID().toString().substring(0,6); //a98ea7
//      // 2) 메일 발송
//      StringBuffer str = new StringBuffer();
//      str.append("<html>");
//      str.append("<p><b>");
//      str.append(tmpPwd);
//      str.append("</b></p>");
//      str.append("<p><a href='http://localhost:9080/login'>로그인 후 비밀번호를 변경하시기 바랍니다.</a></p>");
//      str.append("</html>");
//
//      mailService.sendMail(email,"임시비밀번호 송부",str.toString());
//      return "OK";
//    }
//
//    return "회원정보가 없습니다.";
//  }
}
