package com.kh.demo.web.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResponse<T> {
  private Header header;    //응답메세지 헤더
  private T body;           //응답메시제 바디
  private int totalCnt;     //총레코드수
  private int recCnt;       //1회 가져올 조회레코드 수
  private int reqPage;      //요청 페이지

  private ApiResponse(Header header, T body){
    this.header = header;
    this.body = body;
  }

  @Getter
  @ToString
  @AllArgsConstructor
  private static class Header {
    String rtcd;    //응답코드
    String rtmsg;   //응답메세지
  }

  public static <T> ApiResponse<T> createApiResponse(String rtcd,String rtmsg,T body){
    return new ApiResponse<T>(new Header(rtcd,rtmsg),body);
  }
}
