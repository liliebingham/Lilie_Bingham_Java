package com.company.randomizer.controllers;

import com.company.randomizer.models.Definition;
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
public class DefinitionController {

    private List<Definition> defList;
    private static int idCounter = 1;

    public DefinitionController() {
        defList = new ArrayList<>();

        defList.add(new Definition("rat", "any of several long-tailed rodents of the family Muridae, of the genus Rattus and related genera, distinguished from the mouse by being larger", idCounter++));
        defList.add(new Definition("vermillion", "of a vivid red to reddish-orange color", idCounter++));
        defList.add(new Definition("pique", "call forth, as an emotion, feeling, or response", idCounter++));
        defList.add(new Definition("lollygag", "spend time aimlessly; idle", idCounter++));
        defList.add(new Definition("scrumptious", "(of food) extremely tasty; delicious", idCounter++));
        defList.add(new Definition("scoot", "go or leave somewhere quickly", idCounter++));
        defList.add(new Definition("frolic", "(of an animal or person) play and move about cheerfully, excitedly, or energetically", idCounter++));
        defList.add(new Definition("pneumonoultramicroscopicsilicovolcanoconiosis", "a pneumoconiosis caused by inhalation of very fine silicate or quartz dust", idCounter++));
        defList.add(new Definition("quixotic", "exceedingly idealistic; unrealistic and impractical", idCounter++));
        defList.add(new Definition("clowder", "a group of cats", idCounter++));


    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord() {
        Collections.shuffle(defList);
        return defList.get(0);
    }
}
