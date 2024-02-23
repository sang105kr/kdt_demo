package com.kh.demo.web;


import com.kh.demo.domain.product.svc.ProductSVC;
import com.kh.demo.web.req.product.ReqSave;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ApiProductController {

  private final ProductSVC productSVC;

  //등록
  @ResponseBody
  @PostMapping      // GET http://localhost:9080/api/products
  public String add(
          //@RequestBody : 요청메세지 바디의 json포맷 문자열=>자바객체로 매핑
          @RequestBody ReqSave reqSave
  ){
    log.info("reqSave={}", reqSave);

    return "ok";
  }
  //조회
  @ResponseBody
  @GetMapping("/{pid}")
  public void findById(){

  }
  //수정
  @ResponseBody
  @PatchMapping("/{pid}")
  public void update(){

  }
  //삭제
  @ResponseBody
  @DeleteMapping("/{pid}")
  public void delete(){

  }
  //목록
  @ResponseBody
  @GetMapping
  public void list(){

  }
}
