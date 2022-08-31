package com.team23.PreProject.answer.dto;

import lombok.*;

import java.time.LocalDateTime;

public class answer_dto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{
        private String content;
        private Integer memberId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Put{
        private String content;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private long answerId;
        private String content;
        private LocalDateTime createDate;
        private LocalDateTime modified_date;
        private boolean isAccepted;
        private long memberId;
        private String id;
        //   private String profileImageLink;
    }
}
