package com.fenil.quizapp.Dao;

import com.fenil.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category = :category order by RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCaterogy(String category, Integer numQ);
}
