package Problem;

import State.BoardState;
import State.IState;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents an instance of a problem
 */
public class BoardProblem implements IProblem{
    IState start;//The start state
    IState goal;//The goal state
    int [][] grid;//The board


    /**
     * The constructor of the class
     * @param xStart - The x coordinates of the start state
     * @param yStart - The y coordinates of the start state
     * @param xGoal - The x coordinates of the goal state
     * @param yGoal - The y coordinates of the goal state
     * @param grid - The given grid
     */
    public BoardProblem(int xStart,int yStart,int xGoal,int yGoal, int [][] grid) {

        this.start = new BoardState(xStart,yStart,this);
        this.goal = new BoardState(xGoal,yGoal,this);
        this.grid = grid;
    }


    @Override
    public IState getStartState() {
        return start;
    }

    @Override
    public IState getGoalState() {
        return goal;
    }

    @Override
    public Set<IState> getLegalStates(IState state) {
        if(! (state instanceof BoardState))
            return null;

        Set<IState> states = new HashSet<>();
        BoardState bs = (BoardState) state;
        int x = bs.getX();
        int y = bs.getY();
        if(isLegalState(x,y))
            states.add(bs);
        else
            return null;

        //Up
        if(isLegalState(x-1,y))
            states.add(new BoardState(x-1,y,this));

        //Down
        if(isLegalState(x+1,y))
            states.add(new BoardState(x+1,y,this));
        //Left
        if(isLegalState(x,y-1))
            states.add(new BoardState(x,y-1,this));
        //Right
        if(isLegalState(x,y+1))
            states.add(new BoardState(x,y+1,this));
        //Up - Left
        if(isLegalState(x-1,y-1))
            states.add(new BoardState(x-1,y-1,this));
        //Up - Right
        if(isLegalState(x-1,y+1))
            states.add(new BoardState(x-1,y+1,this));
        //Down - Left
        if(isLegalState(x+1,y-1))
            states.add(new BoardState(x+1,y-1,this));
        //Down - Right
        if(isLegalState(x+1,y+1))
            states.add(new BoardState(x+1,y+1,this));

        return states;

    }

    /**
     * This function will receive coordinates of a location and will check if it's legal
     * @param x - The x coordinates
     * @param y - The y coordinates
     * @return - True IFF the location is legal
     */
    private boolean isLegalState(int x, int y)
    {
        if(x<0 || x>=grid.length)
            return false;
        if(y<0 || y>=grid[0].length)
            return false;
        return grid[x][y]!=0;
    }



}
