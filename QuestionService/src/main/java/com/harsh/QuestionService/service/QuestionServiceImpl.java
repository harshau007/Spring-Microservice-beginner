package com.harsh.QuestionService.service;

import com.harsh.QuestionService.entities.Questions;
import com.harsh.QuestionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Questions addQuestions(Questions questions) {
        return questionRepository.save(questions);
    }

    @Override
    public List<Questions> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Questions getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Present"));
    }

    @Override
    public List<Questions> findByQuizId(Long id) {
        return questionRepository.findByQuizId(id);
    }
}
