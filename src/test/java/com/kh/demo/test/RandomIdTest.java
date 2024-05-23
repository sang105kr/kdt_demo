package com.kh.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@Slf4j
public class RandomIdTest {

  @Test
  void test(){
    log.info("id={}", UUID.randomUUID().toString().substring(0,6));
  }
}
