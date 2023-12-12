package com.harsh.QuestionService.controller;

import com.harsh.QuestionService.entities.Questions;
import com.harsh.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Questions addQuestions(@RequestBody Questions questions) {
        return questionService.addQuestions(questions);
    }

    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Questions getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Questions> getByQuizId(@PathVariable Long id) {
        return questionService.findByQuizId(id);
    }

}
