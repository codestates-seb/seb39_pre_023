package com.team23.PreProject.answer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team23.PreProject.answer_vote.entity.answer_vote;
import com.team23.PreProject.comment.entity.comment;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.member.entity.member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ANSWER_ID")
    private Integer answerId;

    @Column(name="answer_CONTENT")
    private String answer_content;

    @CreationTimestamp
    @Column(name = "WRITE_DATE")
    private LocalDateTime writeDate;

    @UpdateTimestamp
    @Column(name="MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name="IS_ACCEPTED")
    private boolean isAccepted;

    @Column(name="SCORE")
    private long score = 0;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "answer")
    private List<answer_vote> answerVotes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private post post;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private member member;
}
