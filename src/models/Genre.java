package models;

/**
 * Created by Lindsey on 2017-03-11.
 */
public enum Genre {
    DRAMA("Drama"),
    COMEDY("Comedy"),
    ACTION("Action"),
    DOCUMENTARY("Documentary"),
    HORROR("Horror");

    private String displayName;
    Genre(String displayName){
        this.displayName = displayName;
    }

}
