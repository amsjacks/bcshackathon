package models;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    private List<Genre> genres;

    public Movie(String title, Director director, int yearReleased){
        this.director = director;
        this.title = title;
        this.yearReleased = yearReleased;
        awardWinner = false;
        description = "";
        language = "";
        trailer = null;
        genres = new ArrayList<>();

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

    public URL getTrailer(){
        return trailer;
    }

    public void addGenre(Genre genre){
        genres.add(genre);
    }

}
