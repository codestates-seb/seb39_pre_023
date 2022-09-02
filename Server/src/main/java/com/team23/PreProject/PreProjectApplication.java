package com.team23.PreProject;

import com.team23.PreProject.answer.controller.answer_controller;
import com.team23.PreProject.answer.dto.answer_dto;
import com.team23.PreProject.member.controller.member_controller;
import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
import com.team23.PreProject.post.controller.post_controller;
import com.team23.PreProject.post.dto.post_insert_dto;
import com.team23.PreProject.tag.dto.tag_create;
import com.team23.PreProject.tag.entity.tag;
import com.team23.PreProject.tag.service.tag_service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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
	public CommandLineRunner test(member_controller mem_cont, post_controller post_cont, answer_controller ans_cont, tag_service tag_ser) {
		return args -> {
			System.out.println("\n\n************************************************ insert member start \n\n\n");
			mem_cont.insertMember(new member_create_dto("password","nick","Iddddddd1"));
			System.out.println("\n\ninsert member end ************************************************\n\n\n");
			List<String> tags = new ArrayList<>();
			System.out.println("\n\n************************************************ insert tag start \n\n\n");
			tags.add(tag_ser.createTag(new tag_create("java","test tag for name is java version 10" ,null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java1","test tag for name is java version 11",null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java2","test tag for name is java version 12",null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java3","test tag for name is java version 13",null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java4","test tag for name is java version 14",null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java5","test tag for name is java version 15",null)).getName());
			tags.add(tag_ser.createTag(new tag_create("java6","test tag for name is java version 16",null)).getName());

			tag_ser.createTag(new tag_create("javascript" ,"",null));
			tag_ser.createTag(new tag_create("java" ,"",null));
			tag_ser.createTag(new tag_create("react" ,"",null));
			tag_ser.createTag(new tag_create("react-redux" ,"",null));
			tag_ser.createTag(new tag_create("api" ,"",null));
			tag_ser.createTag(new tag_create("python" ,"",null));
			tag_ser.createTag(new tag_create("spring" ,"",null));
			tag_ser.createTag(new tag_create("git" ,"",null));
			tag_ser.createTag(new tag_create("react-hooks" ,"",null));
			tag_ser.createTag(new tag_create("react-router-dom" ,"",null));
			tag_ser.createTag(new tag_create("css" ,"",null));
			tag_ser.createTag(new tag_create("html" ,"",null));
			tag_ser.createTag(new tag_create("git" ,"",null));
			tag_ser.createTag(new tag_create("github" ,"",null));
			tag_ser.createTag(new tag_create("jquery" ,"",null));
			tag_ser.createTag(new tag_create("flutter" ,"",null));
			tag_ser.createTag(new tag_create("firebase" ,"",null));
			tag_ser.createTag(new tag_create("node.js" ,"",null));
			tag_ser.createTag(new tag_create("typescript" ,"",null));
			tag_ser.createTag(new tag_create("c" ,"",null));
			tag_ser.createTag(new tag_create("c#" ,"",null));


			System.out.println("\n\ninsert tag end ************************************************\n\n\n");

			System.out.println("\n\n************************************************ insert post start \n\n\n");
			post_cont.createPost(new post_insert_dto("post_name1","post_content1",2, tags));
			post_cont.createPost(new post_insert_dto("post_name2","post_content1",2,tags));
			post_cont.createPost(new post_insert_dto("post_name3","post_content1",2,tags));
			post_cont.createPost(new post_insert_dto("post_name4","post_content1",2,tags));
			post_cont.createPost(new post_insert_dto("post_name5","post_content1",2,tags));
			post_cont.createPost(new post_insert_dto("post_name6","post_content1",2,tags));
			System.out.println("\n\ninsert member end ************************************************\n\n\n");
//			private Integer postId;
//			private String content;
//			private Integer memberId;
			System.out.println("\n\n************************************************ insert answer start \n\n\n");
			ans_cont.postAnswer(new answer_dto.Post(1,"answer for question 1",2));
			ans_cont.postAnswer(new answer_dto.Post(2,"answer for question 2",2));
			ans_cont.postAnswer(new answer_dto.Post(3,"answer for question 3",2));
			ans_cont.postAnswer(new answer_dto.Post(2,"answer 2 for question 2",2));
			System.out.println("\n\ninsert answer end ************************************************\n\n\n");




			// 이것저것...
		};
	}

}
