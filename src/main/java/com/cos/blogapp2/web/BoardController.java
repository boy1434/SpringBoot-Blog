package com.cos.blogapp2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp2.domain.board.Board;
import com.cos.blogapp2.domain.board.BoardRepository;
import com.cos.blogapp2.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller 
public class BoardController {
	
	// final 이 붙으면 초기화를 해줘야하는데  초기화를 @RequiredArgsConstructor로 한다
	// 하면 private final BoardRepository boardRepository; 에대한 생성자가 생김 
	private final BoardRepository boardRepository;

	@PostMapping("/board")
	public String save(BoardSaveReqDto dto) {
		
		Board board = dto.toEntity();
		boardRepository.save(board);
		return "redirect:/";
	}
	
		
	// 글 전체 목록으로 이동
	@GetMapping("/board")
	public String list() {
		return "board/list";
	}
	
	// 글 상세보기 페이지로 이동
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id) {
		return "board/detail";
	}
	
	// 글 쓰기 페이지로 이동
	@GetMapping("/board/saveForm")
	public String boardSaveForm() {
		return "board/saveForm";
	}
	
	
}
