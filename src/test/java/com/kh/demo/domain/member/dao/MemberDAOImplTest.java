package com.kh.demo.domain.member.dao;


import com.kh.demo.domain.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberDAOImplTest {

  @Autowired
  MemberDAO memberDAO;

 @Test
 void test(){
   log.info("memberDAO={}", memberDAO.getClass().getName());
 }

  @Test
  @DisplayName("회원가입")
  void inserMember(){
    Member member = new Member();
    member.setEmail("user3@kh.com");
    member.setPasswd("user3");
    member.setNickname("사용자3");
    Long memberId = memberDAO.inserMember(member);
    log.info("memberId={}", memberId);
  }

  @Test
  @DisplayName("이메일(O)")
  void existMemberId(){
    boolean exit = memberDAO.existMemberId("user1@kh.com");
    Assertions.assertThat(exit).isEqualTo(true);
  }
  @Test
  @DisplayName("이메일(X)")
  void dontExistMemberId(){
    boolean exit = memberDAO.existMemberId("zzzz@kh.com");
    Assertions.assertThat(exit).isEqualTo(false);
  }
}
