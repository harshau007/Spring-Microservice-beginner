package com.harsh.QuestionService.repository;

import com.harsh.QuestionService.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
    public List<Questions> findByQuizId(Long id);
}
