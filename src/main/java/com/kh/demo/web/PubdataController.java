package com.kh.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/pubdata")
public class PubdataController {

  @GetMapping("/news")      // get http://localhost:9080/pubdata/news
  public String news(){
    return "pubdata/news";
  }

}
