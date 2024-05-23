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

  @GetMapping("/plot")
  public String showPlot(Model model) {

    String INTERPRETER_PATH = "d:/kdt/anaconda3/python.exe";
    final String SOURCE_PATH = "d:/kdt/projects/pythonDemo/visualization";

    // 파이썬 스크립트 실행
//    ProcessBuilder processBuilder = new ProcessBuilder("python", "test.py");
    ProcessBuilder processBuilder = new ProcessBuilder( INTERPRETER_PATH, "test.py");
    processBuilder.directory(new File(SOURCE_PATH));
    StringBuilder result = new StringBuilder();

    try {
      Process process = processBuilder.start();
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

  @GetMapping("/plot2")
  public String showPlot2(Model model) {

    String INTERPRETER_PATH = "d:/kdt/anaconda3/python.exe";
    final String SOURCE_PATH = "d:/kdt/projects/pythonDemo/visualization";
    // 파이썬 스크립트 실행
    ProcessBuilder processBuilder = new ProcessBuilder( INTERPRETER_PATH, "test.py");
    processBuilder.directory(new File(SOURCE_PATH));
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
