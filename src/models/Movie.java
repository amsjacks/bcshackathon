package models;

import models.exceptions.AlreadyExistsException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lindsey on 2017-03-11.
 */
public class Movie {
    private Director director;
    private String title;
    private String language;
    private Boolean awardWinner;
    private int yearReleased;
    private String description;
    private URL trailer;
    private MoviesRepo repo;

    public Movie(String title, Director director, int yearReleased) throws AlreadyExistsException {
        this.repo = MoviesRepo.getInstance();

        if(repo.inRepo(title, director, yearReleased)) {
            throw new AlreadyExistsException();
        } else {
            this.director = director;
            this.title = title;
            this.yearReleased = yearReleased;
            awardWinner = false;
            description = "";
            language = "";
            trailer = null;
        }
    }

    public Movie(String title, String directorName, int yearReleased) throws AlreadyExistsException {
        this.repo = MoviesRepo.getInstance();
        try {
            director = new Director(directorName);
        } catch (AlreadyExistsException e) {
            director = DirectorRepo.getInstance().getDirector(directorName);
        }

        if(repo.inRepo(title, director, yearReleased)) {
            throw new AlreadyExistsException();
        } else {
            this.title = title;
            this.yearReleased = yearReleased;
            awardWinner = false;
            description = "";
            language = "";
            trailer = null;
        }
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage(){
        return language;
    }

    public void toggleAwardWinner(){
        awardWinner = !awardWinner;
    }

    public boolean returnAwardStatus(){
        return awardWinner;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setTrailer(URL link){
        trailer = link;
    }

    public void setTrailer(String urlString) {
        URL link = null;
        try {
            link = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("Input is not in URL format!");
        }
        trailer = link;
    }

    public URL getTrailer(){
        return trailer;
    }

    public Director getDirector() { return director; }

    public int getYearReleased() { return yearReleased; }

    public String getTitle() { return title; }
}
