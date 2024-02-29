package com.kh.demo.domain.member.dao;


import com.kh.demo.domain.entity.Member;
import lombok.extern.slf4j.Slf4j;
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
  @DisplayName("회원가입")
  void inserMember(){
    Member member = new Member();
    member.setEmail("user3@kh.com");
    member.setPasswd("user3");
    member.setNickname("사용자3");
    Long memberId = memberDAO.inserMember(member);
    log.info("memberId={}", memberId);
  }
}
