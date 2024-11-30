package com.villan.Quiz_app.service;


import com.villan.Quiz_app.model.Question;
import com.villan.Quiz_app.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuetionService {

    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<List<Question>> getAllQuetion() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);

    }

    public ResponseEntity<List<Question>> getQuetionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);



    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteById(Integer id) {
        try {
            questionRepo.deleteById(id);
            return new ResponseEntity<>("Success",HttpStatus.OK);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Falied",HttpStatus.BAD_REQUEST);
    }
}
