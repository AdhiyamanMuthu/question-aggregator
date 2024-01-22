package com.code.coder.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.code.coder.models.Question;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PracticeService {

	@Transactional(value = TxType.REQUIRED)
	public void generateSql(Question question) throws FileNotFoundException, IOException {

	}
	
}
