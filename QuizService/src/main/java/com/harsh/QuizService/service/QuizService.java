package com.harsh.QuizService.service;

import com.harsh.QuizService.entities.Quiz;
import com.harsh.QuizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface QuizService {

    public Quiz add(Quiz quiz);

    public List<Quiz> get();

    public Quiz getQuiz(Long id);
}
