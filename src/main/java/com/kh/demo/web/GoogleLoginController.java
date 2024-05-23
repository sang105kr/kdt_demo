package com.kh.demo.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GoogleLoginController {
  @GetMapping("/google/login")
  public String googleLogin(HttpServletRequest request) {
    String redirectUrl = "https://accounts.google.com/o/oauth2/v2/auth"
            + "?client_id=" + "404308634479-bm36ognkesth76vtos73a5ftjiv2sjpl.apps.googleusercontent.com"
            + "&redirect_uri=" + "http://localhost:9080/google/callback"
            + "&response_type=code"
            + "&scope=email profile";
    return "redirect:" + redirectUrl;
  }

  @GetMapping("/google/callback")
  public String googleCallback(@RequestParam("code") String authorizationCode, Model model) {
    log.info("code={}", authorizationCode);
    // 인증 코드를 사용하여 액세스 토큰 및 사용자 정보 가져오기
    // 사용자 정보를 데이터베이스에 저장하거나 세션에 저장하는 등의 로직 구현
    return "redirect:/"; // 로그인 성공 후 리디렉션할 URL
  }
}

