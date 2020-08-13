package com.dc.jokes.RandomJokes.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Service
public class GenerateJokesImpl implements GenerateJokes {
    /***
     ** Author: Dominic Coutinho
     ** Created On: Mar, 2020
     ** Description: Jokes service implementation to fetch a random joke
     **
     */
    private static List<String> jokesList;

    static{

        Path fPath = FileSystems.getDefault().getPath("src","main","resources","RandomJokes.txt");

        if(Files.exists(fPath)) {

            try {
                jokesList = Files.readAllLines(fPath);
                System.out.println(jokesList.size()+" jokes loaded from file");
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
        else {
            System.out.println("File is not available at "+fPath.toAbsolutePath());
        }
    }

    private static List<String> getJokesList() {
        return jokesList;
    }

    @Override
    public String getJoke() {
        System.out.println("Inside getJoke method of GenerateJokesImpl");
        Random r = new Random();
        return getJokesList().get(r.nextInt(getJokesList().size()));
    }
}
