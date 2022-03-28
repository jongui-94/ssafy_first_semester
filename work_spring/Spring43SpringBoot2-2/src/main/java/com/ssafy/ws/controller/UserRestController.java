package com.ssafy.ws.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.UserService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService uService;

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) throws UnsupportedEncodingException {
		User selected = uService.select(user);

		if (selected != null) {
			Cookie cookie = new Cookie("loginId", 
					URLEncoder.encode(selected.getUserId(), "utf-8"));

			cookie.setPath("/");
			cookie.setMaxAge(10 * 60);  // 초 단위, 10분
			response.addCookie(cookie);

			return new ResponseEntity<User>(selected, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/user/logout")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				Cookie removeCookie = new Cookie("loginId", "");
				removeCookie.setPath("/");
				removeCookie.setMaxAge(0);
				response.addCookie(removeCookie);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}

		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/user/me")
	public ResponseEntity<?> me(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				
				String userId = cookie.getValue();
				User selected = uService.selectByUserId(userId);
				
				return new ResponseEntity<User>(selected, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
