package com.kh.demo.web;


import com.kh.demo.domain.entity.Product;
import com.kh.demo.domain.product.svc.ProductSVC;
import com.kh.demo.web.api.ApiResponse;
import com.kh.demo.web.req.product.ReqSave;
import com.kh.demo.web.req.product.ResFindById;
import com.kh.demo.web.req.product.ResSave;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    Long productId = productSVC.save(product);

    ResSave resSave = new ResSave(productId,reqSave.getPname());

    String rtDetail = "상품번호 " + productId + " 가 등록 되었습니다";
    ApiResponse<ResSave> res = ApiResponse.createApiResponseDetail(
            ResCode.OK.getCode(), ResCode.OK.name(), rtDetail, resSave);
    return res;
  }
  //조회
  @ResponseBody
  @GetMapping("/{pid}")
  public ApiResponse<ResFindById> findById(@PathVariable("pid") Long pid){
    log.info("pid={}", pid);
    Optional<Product> optionalProduct = productSVC.findById(pid);

    ApiResponse<ResFindById> res = null;
    //상품을 찾은경우
    if(optionalProduct.isPresent()){
      Product findedPorudct = optionalProduct.get();

      ResFindById resFindById = new ResFindById();
      BeanUtils.copyProperties(findedPorudct,resFindById);

      res = ApiResponse.createApiResponse(ResCode.OK.getCode(), ResCode.OK.name(),resFindById );
    //상품을 못찾은경우
    }else{
      String rtDetail = "상품번호 : " + pid + " 찾고자하는 상품정보가 없습니다.";
      res = ApiResponse.createApiResponseDetail(ResCode.FAIL.getCode(), ResCode.FAIL.name(),rtDetail,null );
    }
    return res;
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
