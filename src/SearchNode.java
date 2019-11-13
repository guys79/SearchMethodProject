import State.IState;

/**
 * This class represents a SearchNode in the Search Algorithm
 */
public class SearchNode {

    private IState state;//The state the node represents
    private double gVal;//The g value of the node
    private double hVal;//The h value of the node

    /**
     * The constructor of the class
     * @param state - The state
     * @param gVal - the gValue
     * @param hVal - The hValue
     */
    public SearchNode(IState state, double gVal, double hVal)
    {
        this.state = state;
        this.gVal = gVal;
        this.hVal = hVal;
    }
    /**
     * This function will return the state that the node represents
     * @return - The represented state
     */
    public IState getState() {
        return state;
    }

    /**
     * This function will return the g value of the node
     * @return - The g value of the node
     */
    public double getGVal() {
        return gVal;
    }

    /**
     * This function will return the h value of the node
     * @return - The h value of the node
     */
    public double getHVal() {
        return hVal;
    }

    /**
     * This function will return the f value of the node
     * @return - The f value of the node
     */
    public double getFVal() {
        return hVal +gVal;
    }
}
