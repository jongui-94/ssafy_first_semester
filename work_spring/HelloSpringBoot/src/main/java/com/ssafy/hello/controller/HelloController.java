package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hsb")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕하세요 스프링 부트!!");
		return "hello";
	}

}
