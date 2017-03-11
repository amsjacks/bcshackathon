package models;

import java.util.Set;

/**
 * Created by aislin on 2017-03-11.
 */
public class SelectionState {
    private Set<Identity> selected;
    private MoviesRepo moviesRepo;
    private boolean isAnySelected;     // true for 'any', false for 'all'

}
