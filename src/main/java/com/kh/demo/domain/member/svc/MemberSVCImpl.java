package com.kh.demo.domain.member.svc;

import com.kh.demo.domain.entity.Member;
import com.kh.demo.domain.member.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC{

  private final MemberDAO memberDAO;

//  @Autowired
//  public MemberSVCImpl(MemberDAO memberDAO) {
//    this.memberDAO = memberDAO;
//  }

  @Override
  public Long joinMeber(Member member) {
    return memberDAO.inserMember(member);
  }
}
