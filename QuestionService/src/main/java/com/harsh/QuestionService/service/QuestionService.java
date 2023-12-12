package com.harsh.QuestionService.service;

import com.harsh.QuestionService.entities.Questions;

import java.util.List;

public interface QuestionService {

    public Questions addQuestions(Questions questions);

    public List<Questions> getQuestions();

    public Questions getQuestionById(Long id);

    public List<Questions> findByQuizId(Long id);
}
