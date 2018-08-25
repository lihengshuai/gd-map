package com.gdmap.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@Slf4j
public class WebController {

  @GetMapping("/gd")
  public String toMap(Model model) {
    return "index";
  }

}
