package com.ssafy.springtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTestController {

	@GetMapping("/springtest")
	public ResponseEntity<String> springtest() {
		
		// Service > DAO 작성
		
		return new ResponseEntity<String>("Spring Test !!", HttpStatus.OK);
	}
}
