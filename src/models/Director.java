package models;

import models.exceptions.AlreadyExistsException;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a director.
 *
 * Created by aislin on 2017-03-11.
 */
public class Director {
    private Set<Identity> identitySet;
    private Set<Movie> moviesDirected;
    private String name;
    private int id;
    private DirectorRepo repo;

    public Director(String name) throws AlreadyExistsException {
        repo = DirectorRepo.getInstance();
        if (repo.getDirector(name) != null) {
            throw new AlreadyExistsException();
        }
        else {
            this.name = name;
            this.id = repo.getNextID();
            moviesDirected = new HashSet<>();
            identitySet = new HashSet<>();
            repo.addDirector(this);
        }
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Movie> getMoviesDirected() {
        Set<Movie> result = new HashSet<>();
        for (Movie movie : moviesDirected) {
            //TODO
        }
        return result;
    }

    public void addMovieDirected(Movie movie) {
        moviesDirected.add(movie);
    }

    public Set<Identity> getIdentitySet() {
        //TODO
        return new HashSet<Identity>();
    }

    public void addIdentity(Identity identity) {
        // TODO
    }

}
