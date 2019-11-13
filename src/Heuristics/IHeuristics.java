package Heuristics;

import State.IState;

/**
 * This interface represents the heuristic function in the search algorithm
 */
public interface IHeuristics {
    /**
     * This function will return the heuristic value of the State.IState "state" considering the goalState
     * @param state - The state that we want to get it;s heuristic value
     * @param goalState - The goal state
     * @return - The heuristic value
     */
    public double getHeiristicValue(IState state, IState goalState);
}
