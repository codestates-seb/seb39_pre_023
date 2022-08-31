package com.team23.PreProject.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class comment_dto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostAnswer{
        private Integer answerId;
        private Integer memberId;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostPost{
        private Integer postId;
        private Integer memberId;
        private String content;
    }
    @Getter
    @NoArgsConstructor
    public static class Put{
        private String content;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostResponse {
        private Integer commentId;
        private String content;
        private String id;
        private String profileImageLink;
        private LocalDateTime createDate;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetResponse{
        private Integer commentId;
        private String content;
        private String id;
        private String profileImageLink;
        private LocalDateTime createDate;
        private boolean isUpdate;
    }
}
