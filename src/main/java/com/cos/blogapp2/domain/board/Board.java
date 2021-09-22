package com.cos.blogapp2.domain.board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.cos.blogapp2.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter // 템플릿 엔진에 나중에 뿌릴때 이거 없으면 EL 표현식으로 뿌릴수가 없다
@Entity
public class Board {

	@Id // PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Lob  // 칼럼을 4GB로 생성
	private String content;
	
	@ManyToOne
	private User user;
}
