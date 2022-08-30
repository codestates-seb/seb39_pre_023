package com.team23.PreProject;

import com.team23.PreProject.member.controller.member_controller;
import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
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
	public CommandLineRunner test(member_repository repo, member_service service, member_controller cont) {
		return args -> {
			cont.insertMember(new member_create_dto("password","nick","Id1"));



			// 이것저것...
		};
	}

}
