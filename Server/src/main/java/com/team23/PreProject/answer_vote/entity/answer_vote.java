package com.team23.PreProject.answer_vote.entity;

import com.team23.PreProject.answer.entity.answer;
import com.team23.PreProject.member.entity.member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class answer_vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerVoteId;

    @Column
    private Integer score=0;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private com.team23.PreProject.answer.entity.answer answer;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private com.team23.PreProject.member.entity.member member;
}
