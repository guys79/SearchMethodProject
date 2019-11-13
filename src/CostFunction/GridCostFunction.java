package CostFunction;

import State.BoardState;
import State.IState;

public class GridCostFunction extends AbstractCostFunction {
    /**
     * The private constructor of the class
     */
    protected GridCostFunction() {
        super();
    }

    @Override
    public double getCost(IState from, IState to) {
        if(!(from instanceof BoardState && to instanceof BoardState))
            return Double.MAX_VALUE;

        BoardState bsFrom = (BoardState)from;
        BoardState bsTo = (BoardState)to;

        int xFrom = bsFrom.getX();
        int yFrom = bsFrom.getY();
        int xTo = bsTo.getX();
        int yTo = bsTo.getY();

        int diffX = Math.abs(xFrom-xTo);
        int diffY = Math.abs(yFrom-yTo);

        if(diffX >1 || diffY>1)
            return Double.MAX_VALUE;

        //Diagonal
        if(diffX == 1 && diffY ==1)
        {
            return Math.sqrt(2);
        }
        //Same location
        if(diffX == 0 && diffY ==0)
        {
            return 0;
        }

        //Adjacent
        return 1;
    }
}
