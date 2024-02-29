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
//  public MemberSVCImpl(@Qualifier("memberDAOImpl2") MemberDAO memberDAO) {
//    this.memberDAO = memberDAO;
//    log.info("memberDAO={}", memberDAO.getClass().getName());
//  }

  @Override
  public Long joinMember(Member member) {
    return memberDAO.inserMember(member);
  }

  @Override
  public boolean existMemberId(String email) {
    return memberDAO.existMemberId(email);
  }
}
