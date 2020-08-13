package com.dc.jokes.RandomJokes.Controller;

import com.dc.jokes.RandomJokes.Service.GenerateJokes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    /***
     ** Author: Dominic Coutinho
     ** Created On: Mar, 2020
     ** Description: Jokes controller class to resolve localhost:8080/RandomJokes/
     **
     */

    private final GenerateJokes joke;

    public JokesController(GenerateJokes joke) {
        this.joke = joke;
    }

    @RequestMapping("/")
    public String getJoke(Model model) {

        System.out.println("Inside JokeController's getJoke method");
        model.addAttribute("joke",joke.getJoke());

        //Thymeleaf template name
        return "Jokes";
    }
}
