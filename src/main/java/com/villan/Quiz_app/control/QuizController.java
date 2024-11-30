package com.villan.Quiz_app.control;

import com.villan.Quiz_app.model.Question;
import com.villan.Quiz_app.model.QuestionWrapper;

import com.villan.Quiz_app.model.Responses;
import com.villan.Quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuetions(@PathVariable int id)
    {

        return quizService.getQuizQuetions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitAnswer(@PathVariable Integer id,@RequestBody List<Responses> responses)
    {
            return quizService.submitAnswer(id,responses);
    }
}
