package com.villan.Quiz_app.service;

import com.villan.Quiz_app.model.Question;
import com.villan.Quiz_app.model.QuestionWrapper;
import com.villan.Quiz_app.model.Quiz;
import com.villan.Quiz_app.model.Responses;
import com.villan.Quiz_app.repo.QuestionRepo;
import com.villan.Quiz_app.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions=questionRepo.findRandomQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(quiz);
        return new  ResponseEntity<>("Success", HttpStatus.CREATED);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuetions(int id) {

        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers=new ArrayList<>();

        for(Question q:questionsFromDB)
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitAnswer(Integer id, List<Responses> responses) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Responses responses1:responses)
        {
            if(responses1.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
