package com.code.coder.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.coder.models.Question;
import com.code.coder.repository.QuestionRepo;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin
public class ExternalController {

	@Autowired
	QuestionRepo qRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalController.class);

	@GetMapping(value = "/topics/{topic}")
	public List<String> getQuestionsOfTopics(@PathVariable("topic") String topic) {
		return qRepo
			.findNamesByTopic(topic)
			.stream()
			.map((name) -> name.getName())
			.toList();
	}

	@GetMapping(value = "/topics")
	public List<String> getTopics() {
		List<String> topics = new ArrayList<>();
		topics.add("DSA");
		topics.add("ML");
		topics.add("Front-end");
		return topics;
	}

	@GetMapping(value = "/{topic}/questions/{question}")
	public Question getQuestion(@PathVariable("topic") String topic, @PathVariable("question") String question)
			throws Exception {
		return qRepo
				.findById(question)
				.orElseThrow(() -> new Exception("Question not available"));
	}

	@PostMapping(value = "/question")
	@Transactional
	public ResponseEntity<String> createQuestion(@RequestBody Question question) {
		Question persistedQuestion = qRepo.save(question);
		LOGGER.info("Question Persisted : {}", persistedQuestion);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body("Question created successfully");
	}

}
