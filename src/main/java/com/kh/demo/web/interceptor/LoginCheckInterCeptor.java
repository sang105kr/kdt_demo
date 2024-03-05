package com.kh.demo.web.interceptor;

import com.kh.demo.web.form.member.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterCeptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    String requestURI = request.getRequestURI();
    log.info("요청url={}",requestURI);

    HttpSession session = request.getSession();
    if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null){
      log.info("미인증요청");
      // 302 http://localhost:9080/login
      response.sendRedirect("/login");
    }
    return true;
  }
}
