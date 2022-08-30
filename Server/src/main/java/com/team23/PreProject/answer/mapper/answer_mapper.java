package com.team23.PreProject.answer.mapper;

import com.team23.PreProject.answer.dto.answer_dto;
import com.team23.PreProject.answer.entity.answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface answer_mapper {
    answer answerPostToanswer(answer_dto.Post requestBody);
    default List<answer_dto.Response> answersToanswerResponseDto(List<answer> answers){
        return answers
                .stream()
                .map(answer -> answer_dto.Response
                        .builder()
                        .answerId(answer.getAnswerId())
                        .content(answer.getAnswer_content())
                        .createDate(answer.getWriteDate())
                        .modified_date(answer.getModifiedDate())
                        .isAccepted(answer.isAccepted())
                        .memberId(answer.getMember().getMemberId())
//                        .profileImageLink(answer.getMember().getProfile().getProfileImageLink())
                        .build())
                .collect(Collectors.toList());
    }
}
