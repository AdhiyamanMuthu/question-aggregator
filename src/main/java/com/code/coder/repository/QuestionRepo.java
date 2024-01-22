package com.code.coder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.coder.models.Question;

public interface QuestionRepo extends JpaRepository<Question, String>{

	List<Question> findByTopic(String topic);
	
	List<NameOnly> findNamesByTopic(String topic);
	
	interface NameOnly {
	    String getName();
	}

}
