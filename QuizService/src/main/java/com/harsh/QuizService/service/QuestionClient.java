package com.harsh.QuizService.service;

import com.harsh.QuizService.entities.Questions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/questions/quiz/{id}")
    List<Questions> getQuestionOfQuiz(@PathVariable Long id);
}
