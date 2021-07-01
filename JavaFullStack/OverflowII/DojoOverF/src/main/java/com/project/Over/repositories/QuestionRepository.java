package com.project.Over.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.Over.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
