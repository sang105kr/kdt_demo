package com.kh.demo.domain.member.svc;

import com.kh.demo.domain.entity.Member;

public interface MemberSVC {
  //회원가입
  Long joinMember(Member member);

  //회원 아이디 조회
  boolean existMemberId(String email);

  //회원조회

  //회원수정

  //회원탈퇴
}
