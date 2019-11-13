package State;

import java.util.Set;

/**
 * This interface represents a generic state
 */
public interface IState {

    /**
     * This function will return the neighbor states of this state
     * (all the states that we can reach by preforming a single operator)
     * @return - A set of all the neighbors
     */
    public Set<IState> expand();


}
