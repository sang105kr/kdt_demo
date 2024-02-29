package com.kh.demo.domain.member.dao;

import com.kh.demo.domain.entity.Member;

public interface MemberDAO {
  //회원가입
  Long inserMember(Member member);

  //회원 아이디 조회
  boolean existMemberId(String email);

  //회원수정

  //회원탈퇴
}
