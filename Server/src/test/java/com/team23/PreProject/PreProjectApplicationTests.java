package com.team23.PreProject;

import com.team23.PreProject.Service.AnswerService;
import com.team23.PreProject.Service.CommentService;
import com.team23.PreProject.Service.ProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class PreProjectApplicationTests {
	@Autowired
	AnswerService answerService;
	@Autowired
	CommentService commentService;
	@Autowired
	ProfileService profileService;
	@Autowired
	private MockMvc mockMvc;



	@Test
	void answer_post_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						post("/api/answer/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/answer/{questionid} [POST]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"post-answer",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
								pathParameters( // 5
										parameterWithName("uid").description("질문글 uid") // 6
								)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void answer_check_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						post("/api/answer/check/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/answer/check/{questionid} [POST]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"check-answer",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void answer_get_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						get("/api/answer/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/answer/{questionid} [GET]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"get-answer",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void answer_del_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						delete("/api/answer/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/answer/{questionid} [DELETE]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"delete-answer",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}
	@Test
	void answer_put_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						put("/api/answer/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/answer/{questionid} [PUT]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"put-answer",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}


	@Test
	void comment_post_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						post("/api/comment/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/comment/{answerid} [POST]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"post-comment",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}


	@Test
	void comment_get_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						get("/api/comment/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/comment/{answerid} [GET]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"get-comment",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void comment_del_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						delete("/api/comment/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/comment/{answerid} [DELETE]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"delete-comment",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}
	@Test
	void comment_put_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						put("/api/comment/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/comment/{answerid} [PUT]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"put-comment",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void profile_post_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						post("/api/users/picture/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/users/picture/{uid} [POST]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"post-profile-pic",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}

	@Test
	void profile_del_test() throws Exception {

		ResultActions actions =
				mockMvc.perform(
						delete("/api/users/picture/{uid}","111")
				);

		actions.andExpect(status().isOk())
				.andExpect(jsonPath("$.request").value("/api/users/picture/{uid} [DELETE]"))
				.andExpect(jsonPath("$.parameter").value("111"))
				.andDo(document(       // (9)
						"delete-profile-pic",     // (9-1)
						preprocessRequest(prettyPrint()),      // (9-2)
						preprocessResponse(prettyPrint()),     // (9-3)
						pathParameters( // 5
								parameterWithName("uid").description("질문글 uid") // 6
						)            // (9-4)
						,
						responseFields(        // (9-6)
								List.of(
										fieldWithPath("request").description("요청 API"),
										fieldWithPath("parameter").description("입력된 파라미터")

								)
						)
				));
	}





}
