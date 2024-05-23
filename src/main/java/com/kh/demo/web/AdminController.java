package com.kh.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

  final String INTERPRETER_PATH = "d:/kdt/anaconda3/python.exe";
  final String PYTHON_SOURCE_PATH = "d:/kdt/projects/pythonDemo2/visualization";

  // 물리적인 이미지 파일이 없이 메모리 입출력
  @GetMapping("/plot")
  public String showPlot(Model model) {

    // 파이썬 스크립트 실행
    // ProcessBuilder : 외부 스크립트파일 실행
    ProcessBuilder processBuilder = new ProcessBuilder( INTERPRETER_PATH, "test.py");
    processBuilder.directory(new File(PYTHON_SOURCE_PATH));
    
    // 외부 스크립트파일 실행 결과를 저장하기위한 문자열 객체
    StringBuilder result = new StringBuilder();

    try {
      Process process = processBuilder.start(); // 외부 스크립트 실행
      // 외부 스크립트 실행 결과를 읽어들여 메모리에 저장
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        result.append(line);
      }
      process.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    // base64 인코딩된 이미지 데이터를 모델에 추가
    model.addAttribute("imageData", result.toString());
    return "admin/plot";
  }

  // 물리적인 이미지 파일이 있는 경우
  @GetMapping("/plot2")
  public String showPlot2(Model model) {

    // 파이썬 스크립트 실행
    ProcessBuilder processBuilder = new ProcessBuilder( INTERPRETER_PATH, "test.py");
    processBuilder.directory(new File(PYTHON_SOURCE_PATH));
    try {
      processBuilder.start().waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    // 이미지 파일 경로를 모델에 추가
    model.addAttribute("imagePath", "/images/plot.png");
    return "admin/plot";
  }
}
