package com.kh.demo.domain.member.dao;

import com.kh.demo.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

  private final NamedParameterJdbcTemplate template;

  //회원가입
  @Override
  public Long inserMember(Member member){
    StringBuffer sql = new StringBuffer();
    sql.append("insert into member (member_id,email,passwd,nickname) ");
    sql.append("values(member_member_id_seq.nextval,'user1@kh.com','user1','사용자1') ");
    

    return 1L;
  }
}
