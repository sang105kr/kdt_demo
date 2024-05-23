package com.kh.demo.domain.member.svc;

import com.kh.demo.domain.entity.Member;

import java.util.Optional;

public interface MemberSVC {
  //회원가입
  Long joinMember(Member member);

  //회원 아이디 조회
  boolean existEmail(String email);

  //회원조회
  Optional<Member> findByEmailAndPasswd(String email, String passwd);

  //회원수정

  //회원탈퇴

  //비밀번호 유무확인
  boolean hasPasswd(String email, String nickname);

  //비밀번호 변경
  int changePasswd(String email, String passwd);
}
