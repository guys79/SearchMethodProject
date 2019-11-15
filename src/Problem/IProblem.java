package Problem;

import State.IState;

import java.util.Set;

/**
 * This interface represents a single problem
 */
public interface IProblem {


    /**
     * This function will return the start state
     * @return - The start state
     */
    public IState getStartState();

    /**
     * This function will return the goal state
     * @return - The goal state
     */
    public IState getGoalState();

    /**
     * This function will return the legal states reachable from the given state
     * @param state - The given state
     * @return - The legal states reachable from the given state
     */
    public Set<IState> getLegalStates(IState state);
}
