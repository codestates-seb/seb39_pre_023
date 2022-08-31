package com.team23.PreProject;

import com.team23.PreProject.member.controller.member_controller;
import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
import com.team23.PreProject.post.controller.post_controller;
import com.team23.PreProject.post.dto.post_insert_dto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class PreProjectApplication {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {

		SpringApplication.run(PreProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(member_controller mem_cont, post_controller post_cont) {
		return args -> {
			mem_cont.insertMember(new member_create_dto("password","nick","Iddddddd1"));
			post_cont.post_test(new post_insert_dto("post_name1","post_content1",2));
			post_cont.post_test(new post_insert_dto("post_name2","post_content1",2));
			post_cont.post_test(new post_insert_dto("post_name3","post_content1",2));
			post_cont.post_test(new post_insert_dto("post_name4","post_content1",2));
			post_cont.post_test(new post_insert_dto("post_name5","post_content1",2));
			post_cont.post_test(new post_insert_dto("post_name6","post_content1",2));


			// 이것저것...
		};
	}

}
