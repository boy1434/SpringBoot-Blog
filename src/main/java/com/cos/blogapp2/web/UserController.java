package com.cos.blogapp2.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp2.domain.user.User;
import com.cos.blogapp2.domain.user.UserRepository;
import com.cos.blogapp2.util.SHA;
import com.cos.blogapp2.web.dto.JoinReqDto;
import com.cos.blogapp2.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		String encPassword = SHA.encrypt(dto.getPassword());
		User principal = userRepository.mLogin(dto.getUsername(), encPassword);
		
		if(principal == null) { // principal 이  null 이면 로그인이 안됨.
			return "redirect:/loginForm";
		}else {
			session.setAttribute("principal", principal); //  해쉬면 키 값으로 값을 저장
			return "redirect:/";  // null이 아니면 로그인
		}
	}
	
	//  회원가입을 하면 로그인 화면으로 이동한다
	@PostMapping("/join")
	public String join(JoinReqDto dto) { 
		// 데이터를 username=ssar&password=1234&email=ssar@nate.com 
        // 마임타입 = urlencoded 형식으로 가져온다

		String encPassword = SHA.encrypt(dto.getPassword());
		dto.setPassword(encPassword);
		
		User user = dto.toEntity();
		userRepository.save(user);
		
		return "redirect:/loginForm";
	}
	
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
	
	// 글 상세보기 페이지로 이동
	@GetMapping("/user/{id}")
	public String userInfo(@PathVariable int id) {
		return "user/updateForm";
	}
	
}
