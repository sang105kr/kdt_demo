package com.kh.demo.domain.common;

import com.kh.demo.domain.common.mail.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {
  
  @Autowired
  private MailService mailService;
  
  @Test
  void sendSimpleMail(){
    StringBuffer str = new StringBuffer();
    str.append("<html>");
    str.append("<head><style>p { color:blue; font-size:30px; }</style></head>");
    str.append("<body>");
    str.append("<p><b>이메일 인증번호</b></p>");
    str.append("</body>");
    str.append("</html>");
    mailService.sendMail("sang105kr2@naver.com","이메일인증",str.toString());
  }
}
