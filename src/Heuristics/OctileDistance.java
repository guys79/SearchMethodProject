package Heuristics;

import State.BoardState;
import State.IState;

/**
 * This class represents the Octile distance heuristics
 */
public class OctileDistance implements IHeuristics {
    @Override
    public double getHeiristicValue(IState state, IState goalState) {
        if(!(state instanceof BoardState && goalState instanceof BoardState))
            return Double.MAX_VALUE;

        BoardState bState = (BoardState)state;
        BoardState bGoalState = (BoardState)goalState;

        int xBState = bState.getX();
        int yBState = bState.getY();
        int xBGoalState = bGoalState.getX();
        int yBGoalState = bGoalState.getY();

        int diffx = Math.abs(xBState-xBGoalState);
        int diffy = Math.abs(yBState-yBGoalState);

        double D =1;
        double D2 =Math.sqrt(2);

        return D * (diffx + diffy) + (D2 - 2 * D) * Math.min(diffx, diffy);

    }
}
