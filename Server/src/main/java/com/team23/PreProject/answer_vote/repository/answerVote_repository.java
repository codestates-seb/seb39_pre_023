package com.team23.PreProject.answer_vote.repository;

import com.team23.PreProject.answer_vote.entity.answer_vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface answerVote_repository extends JpaRepository<answer_vote,Integer> {
}
