package com.company.randomizer.controllers;

import com.company.randomizer.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class QuoteController {

    private List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote("I have not failed. I’ve just found 10,000 ways that won’t work.", "Thomas A. Edison", idCounter++));
        quoteList.add(new Quote("Do not go where the path may lead , go instead where there is no path and leave a trail", "Ralph Waldo Emerson", idCounter++));
        quoteList.add(new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt", idCounter++));
        quoteList.add(new Quote("To live is the rarest thing in the world. Most people exist, that is all.", "Oscar Wilde", idCounter++));
        quoteList.add(new Quote("Go confidently in the direction of your dreams. Live the life you have imagined.", "Henry David Thoreau", idCounter++));
        quoteList.add(new Quote("Friendship is born at that moment when one person says to another: “What! You too? I thought I was the only one.", "C.S. Lewis", idCounter++));
        quoteList.add(new Quote("he most difficult thing is the decision to act; the rest is merely tenacity.", "Amelia Earhart", idCounter++));
        quoteList.add(new Quote("In three words I can sum up everything I’ve learned about life: It goes on.", "Robert Frost", idCounter++));
        quoteList.add(new Quote("A journey of a thousand miles begins with a single step.", "Lao Tzu", idCounter++));
        quoteList.add(new Quote("I’ve learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.", "Maya Angelou", idCounter++));
    }


        @RequestMapping(value = "/quote", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public Quote getQuote() {
            Collections.shuffle(quoteList);
            return quoteList.get(0);
        }
    }

