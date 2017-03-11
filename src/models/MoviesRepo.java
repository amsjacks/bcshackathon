package models;

import models.exceptions.AlreadyExistsException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aislin on 2017-03-11.
 */
public class MoviesRepo {
    private Set<Movie> movies;
    private static MoviesRepo instance;
    private DirectorRepo directorRepo;
    private int nextId;

    private MoviesRepo() {
        nextId = 1;
        movies = new HashSet<>();
        directorRepo = DirectorRepo.getInstance();
    }

    public static MoviesRepo getInstance() {
        if (instance == null) {
            instance = new MoviesRepo();
        }
        return instance;
    }

    public boolean inRepo(String title, Director director, int yearReleased) {
        boolean result = false;
        for (Movie m: movies) {
            if (m.getDirector() == director && m.getYearReleased() == yearReleased && title.equalsIgnoreCase(m.getTitle())) {
                result = true;
            }
        }
        return result;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addMovie(String title, Director director, int yearReleased) throws AlreadyExistsException {
        Movie movie = new Movie(title, director, yearReleased);
        movies.add(movie);
    }

    public void addMovie(String title, String directorName, int yearReleased) throws AlreadyExistsException {
        Movie movie = new Movie(title, directorName, yearReleased);
        movies.add(movie);
    }

    public Set<Movie> getAllMovies() { return movies; }

    // Returns set of movies with directors in the intersection of the identities in the set. Returns no movies for an empty set.
    public Set<Movie> getMoviesAllIdentites(Set<Identity> identities) {
        Set<Movie> result = new HashSet<>();
        for (Movie m : movies) {
            if (m.getDirector().isInAll(identities)) {
                result.add(m);
            }
        }
        return result;
    }

    // Returns set of movies with directors in the union of the identities in the set. Returns all movies for an empty set.
    public Set<Movie> getMoviesAnyIdentites(Set<Identity> identities) {
        Set<Movie> result = new HashSet<>();
        for (Movie m : movies) {
            if (m.getDirector().isInAny(identities)) {
                result.add(m);
            }
        }        return result;
    }
}
