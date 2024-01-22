package com.code.coder.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question_table")
public class Question {
	
	@Id
	@Column(unique = true)
	private String name;
	private String description;
	private List<String>  sampleTestCase;
	private String category;
	private String topic;
	private List<String> hints;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TestCase> testcases;

}
