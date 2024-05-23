package com.kh.demo.web.req.member;

import lombok.Data;

@Data
public class ReqFindPwd {
  private String email;
  private String nickname;
}
