package com.kh.demo.web.req.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class ResFindById {
  private Long productId;
  private String pname;
  private Long quantity;
  private Long price;
  private LocalDateTime cdate;
  private LocalDateTime udate;
}
