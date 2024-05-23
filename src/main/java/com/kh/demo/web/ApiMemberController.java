package com.kh.demo.web;

import com.kh.demo.domain.common.mail.MailService;
import com.kh.demo.domain.member.svc.MemberSVC;
import com.kh.demo.web.api.ApiResponse;
import com.kh.demo.web.api.ResCode;
import com.kh.demo.web.req.member.ReqExitsEmail;
import com.kh.demo.web.req.member.ReqFindPwd;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {

  private final MemberSVC memberSVC;
  private final MailService mailService;

  //회원 중복체크
  @PostMapping("/dupchk")
  public ApiResponse<?> dupchk(@RequestBody ReqExitsEmail reqExitsEmail){
    ApiResponse<?> res = null;
    log.info("reqExitsEmail={}",reqExitsEmail);
    boolean existEmail = memberSVC.existEmail(reqExitsEmail.getEmail());
    if (existEmail) {
      res = ApiResponse.createApiResponse(ResCode.EXIST.getCode(), ResCode.EXIST.name(), null);
    }else{
      res = ApiResponse.createApiResponse(ResCode.NONE.getCode(), ResCode.NONE.name(), null);
    }
    return res;
  }

  //비밀번호 찾기
  @PostMapping("/findPwd")
  public ApiResponse<?> findPwd(@RequestBody ReqFindPwd reqFindPwd){

    ApiResponse<?> res = null;

    log.info("email={}",reqFindPwd.getEmail());
    log.info("nickname={}",reqFindPwd.getNickname());

    boolean hasPasswd = memberSVC.hasPasswd(reqFindPwd.getEmail(), reqFindPwd.getNickname());
    if (hasPasswd) {
      // 1)임시번호 생성 6자리 랜덤 생성
      String tmpPwd = UUID.randomUUID().toString().substring(0,6); //a98ea7
      
      // 2)회원 비밀번호를 임시 비밀번호로 변경
      memberSVC.changePasswd(reqFindPwd.getEmail(), tmpPwd);

      // 3) 메일 발송
      StringBuffer str = new StringBuffer();
      str.append("<html>");
      str.append("<p><b>");
      str.append(tmpPwd);
      str.append("</b></p>");
      str.append("<p><a href='http://localhost:9080/login'>로그인 후 비밀번호를 변경하시기 바랍니다.</a></p>");
      str.append("</html>");

      mailService.sendMail(reqFindPwd.getEmail(),"임시비밀번호 송부",str.toString());
      return ApiResponse.createApiResponse(ResCode.EXIST.getCode(), ResCode.EXIST.name(), null);
    }

    return ApiResponse.createApiResponseDetail(ResCode.NONE.getCode(), ResCode.NONE.name(),"회원정보없음", null);
  }
}
