package com.team23.PreProject.answer.mapper;

import com.team23.PreProject.answer.dto.answer_dto;
import com.team23.PreProject.answer.entity.answer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T00:59:14+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class answer_mapperImpl implements answer_mapper {

    @Override
    public answer answerPostToAnswer(answer_dto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        answer answer = new answer();

        answer.setPostId( requestBody.getPostId() );

        return answer;
    }
}
