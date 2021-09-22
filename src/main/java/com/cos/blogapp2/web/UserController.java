package com.cos.blogapp2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

	// 로그인 페이지로 이동
	@GetMapping("loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	// 회원정보 상세보기 페이지로 이동
	@GetMapping("/user/{id}")
	public String userInfo(@PathVariable int id) {
		return "user/updateForm";
	}
	
}
