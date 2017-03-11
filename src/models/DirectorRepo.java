package models;

import models.exceptions.AlreadyExistsException;

import java.util.HashSet;
import java.util.Set;

/**
 * Repository of all directors with movies in the collection.
 *
 * Created by aislin on 2017-03-11.
 */
public class DirectorRepo {
    private Set<Director> directors;
    private static DirectorRepo instance;
    private int nextId;

    private DirectorRepo() {
        nextId = 1;
        directors = new HashSet<>();
    }

    public static DirectorRepo getInstance() {
        if (instance == null) {
            instance = new DirectorRepo();
        }
        return instance;
    }

    public boolean isInRepo(Director director) {
        boolean result = false;
        for (Director d : directors) {
            if (d.getID() == director.getID()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Director getDirector(String name) {
        Director result = null;
        for (Director d : directors) {
            if (d.getName().equalsIgnoreCase(name)) {
                result = d;
                break;
            }
        }
        return result;
    }

    // TODO: implement sort-by-last-name functionality
    /*public Set<Director> getDirectorsWithLastName(String lastName) {
        Set<Director> result = new HashSet<>();
        for (Director d : directors) {
            if (d.getLastName().equalsIgnoreCase(lastName)) {
                result.add(d);
            }
        }
        return result;
    }*/

    public Set<Director> getDirectorsWithIdentity(Identity identity) {
        Set<Director> result = new HashSet<>();
        for (Director d : directors) {
            if (d.hasIdentity(identity)) {
                result.add(d);
            }
        }
        return result;
    }

    public Set<Director> getAllDirectors() {
        return directors;
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void addDirector(String directorName) {
        try {
            new Director(directorName);
        } catch (AlreadyExistsException e) {
            System.err.println("Director already added!");
        }
    }

    public int getNextID() {
        return nextId++;
    }
}
