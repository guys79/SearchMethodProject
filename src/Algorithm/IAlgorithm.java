package Algorithm;

import State.IState;

import java.util.List;

/**
 * This interface represents a generic search algorithm
 */
public interface IAlgorithm {
    /**
     * This function will return the path from the start state to the goal state
     * (If it can't find a path, the function will return null)
     * @param start - The start state
     * @param goal - The goal state
     * @return - A path from the start state to the goal state
     */
    public List<IState> getPath(IState start, IState goal);
}
