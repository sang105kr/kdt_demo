package com.kh.demo.web;


import com.kh.demo.domain.entity.Product;
import com.kh.demo.domain.product.svc.ProductSVC;
import com.kh.demo.web.api.ApiResponse;
import com.kh.demo.web.req.product.ReqSave;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
  public ApiResponse<?> add(
          //@RequestBody : 요청메세지 바디의 json포맷 문자열=>자바객체로 매핑
          @RequestBody ReqSave reqSave
  ){
    log.info("reqSave={}", reqSave);
    
    //1)유효성검증
    
    //2)상품등록처리
//    Product product = new Product();
//    product.setPname(reqSave.getPname());
//    product.setQuantity(reqSave.getQuantity());
//    product.setPrice(reqSave.getPrice());
    Product product = new Product();
    BeanUtils.copyProperties(reqSave,product);
    productSVC.save(product);

    ApiResponse<?> res = ApiResponse.createApiResponse("00","성공",product);
    return res;
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
