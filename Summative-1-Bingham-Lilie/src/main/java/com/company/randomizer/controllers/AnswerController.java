package com.company.randomizer.controllers;

import com.company.randomizer.models.Answer;
import com.company.randomizer.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AnswerController {

    private List<String> answerList;
    private static int idCounter = 1;

    public AnswerController() {
        answerList = new ArrayList<String>();

        answerList.add("It's possible, I guess?");
        answerList.add("I highly doubt it.");
        answerList.add("Let me think about it. Return in an hour or so.");
        answerList.add("100% yes! Trust me, I've never been wrong!");
        answerList.add("Are you really asking me that?");
        answerList.add("I think you'd know better than I.");
        answerList.add("Probably not but don't lose hope!");
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer answerQuestion(@RequestBody String question) {

        Answer answer = new Answer();
        answer.setId(idCounter++);
        answer.setQuestion(question);
        Collections.shuffle(answerList);
        answer.setAnswer(answerList.get(0));

        return answer;
    }
}
