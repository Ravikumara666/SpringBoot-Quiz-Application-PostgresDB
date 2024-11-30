package com.villan.Quiz_app.control;


import com.villan.Quiz_app.model.Question;
import com.villan.Quiz_app.service.QuetionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quetion")
public class QuetionController {

    @Autowired
    QuetionService quetionService;

    @GetMapping("allquetions")
    public ResponseEntity<List<Question>> getAllQuetions()
    {
        return quetionService.getAllQuetion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCatogery(@PathVariable String category)
    {
        return quetionService.getQuetionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return quetionService.addQuestion(question);
    }
    @PostMapping("delet")
    public ResponseEntity<String> DeleteByID(@RequestBody Integer id)
    {
        return quetionService.deleteById(id);
    }

}
