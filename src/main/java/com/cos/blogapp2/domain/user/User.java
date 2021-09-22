package com.cos.blogapp2.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
@Entity // 이게 있어야 테이블이 만들어진다
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
}
